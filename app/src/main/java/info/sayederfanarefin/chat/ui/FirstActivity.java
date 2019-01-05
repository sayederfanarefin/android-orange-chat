package info.sayederfanarefin.chat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreActivity;
import info.sayederfanarefin.chat.ui.authentication.AuthenticationActivity;
import info.sayederfanarefin.chat.ui.authentication.AuthenticationActivity_;
import info.sayederfanarefin.chat.ui.authentication.AuthenticationFirstFragment_;
import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;
//import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by erfan on 10/5/18.
 */

@EActivity(R.layout.activity_first)
public class FirstActivity extends CoreActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference userRef;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);


    }

    @AfterViews
    void afterViews() {
        loadFragment(FirstFragment_.builder().build());

        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                init_using_firebase_user(firebaseAuth.getCurrentUser());
            }
        };
        init_using_firebase_user(mFirebaseAuth.getCurrentUser());

    }

    private void init_using_firebase_user(FirebaseUser user){
        if (user != null) {
            userRef.child(user.getUid())
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                           // populate_user_info(snapshot.getValue(users.class));
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {}});

        } else {
            AuthenticationActivity_.intent(this).start();
        }
    }
}
