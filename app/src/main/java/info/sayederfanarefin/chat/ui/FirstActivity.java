package info.sayederfanarefin.chat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.adapters.DrawerListAdapter;
import info.sayederfanarefin.chat.core.CoreActivity;
import info.sayederfanarefin.chat.ui.authentication.AuthenticationActivity_;
import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;
//import info.sayederfanarefin.chat.ui.firstFragment.FirstFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

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
    DrawerLayout drawerLayout;

    @ViewById
    ImageView imageViewNavProfilePic;

    @ViewById
    TextView textViewNavUserName;

    @ViewById
    TextView textViewNavUserMood;


    @ViewById
    ListView listViewNavDrawer; //lv_drawer

    @ViewById
    TabLayout tabLayout;

    private ArrayList<String> navigationItems;
    private int[] pageIcon = {
            R.drawable.ic_info_custom,
            R.drawable.ic_time_custom,
            R.drawable.ic_message,
            R.drawable.ic_friends_custom
    };

    public static int[] drawer_icons = {
            R.mipmap.ic_time,
            R.mipmap.message,
            R.mipmap.notification,
            R.mipmap.profile,
            R.mipmap.settings,
            R.mipmap.logout
    };

    private DrawerListAdapter drawerListAdapter;

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

        initializeViews();
//        userRef.keepSynced(true);
    }



    private void redirectToAuthenticateActivityIfNeeded(){
        if (!checkUserIfAuthenticated()) {
            AuthenticationActivity_.intent(this).start();
            finish();
        }
    }

    @Click
    void closeNav(){
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerLayout.openDrawer(drawer2);

        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


    private void SetDrawer() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        drawerListAdapter = new DrawerListAdapter(FirstActivity.this, navigationItems, drawer_icons);
        listViewNavDrawer.setAdapter(drawerListAdapter);

        listViewNavDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(navigationItems.get(position).equalsIgnoreCase("Timeline")){

                }else if(navigationItems.get(position).equalsIgnoreCase("Message")){


                }else if(navigationItems.get(position).equalsIgnoreCase("Profile")){



                }else if(navigationItems.get(position).equalsIgnoreCase("Music")){



                }
                else if(navigationItems.get(position).equalsIgnoreCase("Logout")){


                }
            }
        });

    }


    private void initializeViews(){

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

//custom drawer
        navigationItems = new ArrayList<>();



//adding menu items for naviations
        navigationItems.add("Timeline");
        navigationItems.add("Message");
        navigationItems.add("Music");
        //navigationItems.add("Notifications");
        navigationItems.add("Profile");
        navigationItems.add("Settings");
        navigationItems.add("Logout");

        SetDrawer();


        for (int i = 0; i < pageIcon.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setIcon(pageIcon[i]));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//        viewPager = (ViewPager) findViewById(R.id.view_pager);
//        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(pagerAdapter);
//
//        viewPager.setOffscreenPageLimit(1);
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               // viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        toolbarTitle.setText("Home");
                        break;
                    case 1:
                        toolbarTitle.setText("Timeline");
                        break;
                    case 2:
                        toolbarTitle.setText("Chat");
                        break;
                    case 3:
                        toolbarTitle.setText("Friends");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        //viewPager.setCurrentItem(0);
        toolbarTitle.setText("Home");


    }

}
