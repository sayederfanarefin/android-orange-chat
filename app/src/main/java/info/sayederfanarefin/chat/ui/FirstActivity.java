package info.sayederfanarefin.chat.ui;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreActivity;
import info.sayederfanarefin.chat.ui.authentication.AuthenticationActivity_;
import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;
//import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by erfan on 10/5/18.
 */

@EActivity(R.layout.activity_first)
public class FirstActivity extends CoreActivity {

    @ViewById
    ImageButton closeNav;

    @ViewById
    Toolbar toolbar;

    @ViewById
    TextView toolbarTitle;

    @ViewById
    RelativeLayout drawer2;

    @ViewById
    ImageView imageViewNavProfilePic;

    @ViewById
    TextView textViewNavUserName;

    @ViewById
    TextView textViewNavUserMood;


    @ViewById
    ListView listViewNavDrawer; //lv_drawer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);


    }

    @AfterViews
    void afterViews() {
        getSupportActionBar().hide();
        loadFragment(FirstFragment_.builder().build());
        redirectToAuthenticateActivityIfNeeded();
    }



    private void redirectToAuthenticateActivityIfNeeded(){
        if (!checkUserIfAuthenticated()) {
            AuthenticationActivity_.intent(this).start();
            finish();
        }
    }

}
