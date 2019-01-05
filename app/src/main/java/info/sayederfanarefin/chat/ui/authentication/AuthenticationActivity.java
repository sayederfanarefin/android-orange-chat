package info.sayederfanarefin.chat.ui.authentication;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreActivity;
import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;

/**
 * Created by erfan on 10/5/18.
 */

@EActivity(R.layout.activity_authentication)
public class AuthenticationActivity extends CoreActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        mFirebaseAuth = FirebaseAuth.getInstance();

    }

    @AfterViews
    void afterViews() {
        getSupportActionBar().hide();
        loadFragment(AuthenticationFirstFragment_.builder().build());
    }


}
