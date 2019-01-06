package info.sayederfanarefin.chat.core;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;

import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.commons.Constants;
import info.sayederfanarefin.chat.log.Tracer;
import info.sayederfanarefin.model.users;

import static android.content.Context.MODE_PRIVATE;

@EFragment
public abstract class CoreFirebaseFragment extends CoreFragment {

    DatabaseReference usersRef;
    FirebaseUser firebaseUser;
    private StorageReference storageRef;

    public CoreFirebaseFragment(){

        firebaseUser = getFirebaseUserFromSharedPref();
        usersRef = rootRef.child(Constants.dbUserLocation+ "/" + firebaseUser.getUid());
        storageRef = FirebaseStorage.getInstance().getReference();
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
}
