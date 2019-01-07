package info.sayederfanarefin.chat.core;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import info.sayederfanarefin.chat.commons.Constants;
import info.sayederfanarefin.chat.commons.SharedPrefs;
import info.sayederfanarefin.chat.log.Tracer;
import info.sayederfanarefin.model.users;

@EFragment
public abstract class CoreFirebaseFragment extends CoreFragment {

    public DatabaseReference usersRef;
    public users user;
    public StorageReference storageRef;

    public CoreFirebaseFragment(){

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        SharedPrefs sharedPrefs = new SharedPrefs(context);
        user = sharedPrefs.getUserFromSharedPref();
        usersRef = rootRef.child(Constants.dbUserLocation+ "/" + user.getUid());
        storageRef = FirebaseStorage.getInstance().getReference();
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        Tracer.d(this.getClass().getSimpleName() + " onStop()");
        super.onStop();

    }

    @Subscribe
    public void onGenericEvent(Object event) {
        // DO NOT WRITE CODE
    }
}
