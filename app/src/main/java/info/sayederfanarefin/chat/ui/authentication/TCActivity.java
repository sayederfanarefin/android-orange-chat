package info.sayederfanarefin.chat.ui.authentication;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreActivity;

/**
 * Created by erfan on 10/5/18.
 */

@EActivity(R.layout.activity_tc)
public class TCActivity extends CoreActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);


    }

    @AfterViews
    void afterViews() {
        getSupportActionBar().hide();
        loadFragment(TCFragment_.builder().build());
    }


}
