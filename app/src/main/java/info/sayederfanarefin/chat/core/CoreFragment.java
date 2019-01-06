package info.sayederfanarefin.chat.core;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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

    DatabaseReference rootRef;
    DatabaseReference usersRef;

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

    public void showSnachBar(String message){
        final Snackbar sb =  Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE).setDuration(Constants.SNACK_BAR_TIME_OUT);
        sb.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.dismiss();
            }
        });
        sb.show();
    }


    public void saveUserInSharedPref(users currentUser){
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(currentUser);
        prefsEditor.putString(getString(R.string.sharedPrefCurrentUser), json);
        prefsEditor.commit();
    }

    public users getUserFromSharedPref(){
        Gson gson = new Gson();
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        String json = mPrefs.getString(getString(R.string.sharedPrefCurrentUser), "");
        return gson.fromJson(json, users.class);
    }

    public void saveFirebaseUserInSharedPref(FirebaseUser currentUser){
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(currentUser);
        prefsEditor.putString(getString(R.string.sharedPrefCurrentFirebaseUser), json);
        prefsEditor.commit();
    }

    public FirebaseUser getFirebaseUserFromSharedPref(){
        Gson gson = new Gson();
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        String json = mPrefs.getString(getString(R.string.sharedPrefCurrentFirebaseUser), "");
        return gson.fromJson(json, FirebaseUser.class);
    }

    public void saveStringInSharedPref(String tag, String text){
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        prefsEditor.putString(tag, text);
        prefsEditor.commit();
    }

    public String getStringFromSharedPref(String tag, String def){

        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        return mPrefs.getString(tag, def);

    }

}
