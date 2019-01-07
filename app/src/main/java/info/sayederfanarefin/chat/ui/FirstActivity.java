package info.sayederfanarefin.chat.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.commons.SharedPrefs;
import info.sayederfanarefin.chat.core.CoreActivity;
import info.sayederfanarefin.chat.ui.authentication.AuthenticationActivity_;
import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;
import info.sayederfanarefin.model.users;
//import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by erfan on 10/5/18.
 */

@EActivity(R.layout.activity_first)
public class FirstActivity extends CoreActivity {

    protected FirebaseAuth mFirebaseAuth;
    protected DatabaseReference userRef;
    protected FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);


    }

    @AfterViews
    void afterViews() {
        loadFragment(FirstFragment_.builder().build());
        checkUserIfAuthenticated();
    }


    private void checkUserIfAuthenticated(){
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                initUsingFirebaseUser(firebaseAuth.getCurrentUser());
            }
        };
        initUsingFirebaseUser(mFirebaseAuth.getCurrentUser());
    }
    private void initUsingFirebaseUser(FirebaseUser user){
        if (user != null) {
            userRef.child(user.getUid())
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            SharedPrefs sharedPrefs = new SharedPrefs(getApplicationContext());
                            sharedPrefs.saveUserInSharedPref(snapshot.getValue(users.class));
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {}});

        } else {
            AuthenticationActivity_.intent(this).start();
            finish();
        }
    }

}
