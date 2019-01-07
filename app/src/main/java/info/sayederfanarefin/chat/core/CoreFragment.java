package info.sayederfanarefin.chat.core;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.commons.Constants;
import info.sayederfanarefin.chat.log.Tracer;
import info.sayederfanarefin.model.users;

import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static android.content.Context.MODE_PRIVATE;

@EFragment
public abstract class CoreFragment extends Fragment {

    public final int GALLERY_INTENT = 2;
    public final int REQUEST_PERMISSION_PHONE_STATE = 1;
    public final int REQUEST_PERMISSION_CAMERA = 2;
    public DatabaseReference rootRef;
    public DatabaseReference usersRef;


    public CoreFragment() {
        // Required empty public constructor
        rootRef = FirebaseDatabase.getInstance().getReference();

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        Tracer.d(this.getClass().getSimpleName() + " onStop()");
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onGenericEvent(Object event) {
        // DO NOT WRITE CODE
    }

    public void showSnachBar(String message) {
        final Snackbar sb = Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE).setDuration(Constants.SNACK_BAR_TIME_OUT);
        sb.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.dismiss();
            }
        });
        sb.show();
    }





    private void showPermissionWriteExternalStorage() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                showExplanation("Permission Needed", "Rationale", Manifest.permission.WRITE_EXTERNAL_STORAGE, REQUEST_PERMISSION_PHONE_STATE);
            } else {
                requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, REQUEST_PERMISSION_PHONE_STATE);
                //requestPermission(perms, REQUEST_PERMISSION_PHONE_STATE);
            }
        } else {
            //  Toast.makeText(ProfileActivity.this, "Permission (already) Granted! extstr", Toast.LENGTH_SHORT).show();
        }
    }

    private void showPermissionCamera() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                getContext(), Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.CAMERA)) {
                showExplanation("Permission Needed", "Rationale", Manifest.permission.CAMERA, REQUEST_PERMISSION_CAMERA);
            } else {
                requestPermission(Manifest.permission.CAMERA, REQUEST_PERMISSION_CAMERA);

            }
        }
//        else {
//              Toast.makeText(ProfileActivity.this, "Permission (already) Granted! camera!", Toast.LENGTH_SHORT).show();
//        }
    }


    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String permissions[],
            int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_PHONE_STATE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showSnachBar("Permission Granted!");
                } else {
                    showSnachBar("Permission Denied!");
                }
                REQUEST_PERMISSION_CAMERA:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showSnachBar("Permission Granted!");
                } else {
                    showSnachBar("Permission Denied!");
                }

        }
    }


    private void showExplanation(String title,
                                 String message,
                                 final String permission,
                                 final int permissionRequestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        requestPermission(permission, permissionRequestCode);
                    }
                });
        builder.create().show();
    }

    private void requestPermission(String permissionName, int permissionRequestCode) {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{permissionName}, permissionRequestCode);
    }


}
