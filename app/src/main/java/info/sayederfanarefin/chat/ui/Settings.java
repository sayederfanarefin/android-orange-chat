package info.sayederfanarefin.chat.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.widget.CompoundButton;


import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;

import com.francoisdexemple.materialpreference.ConvenienceBuilder;
import com.francoisdexemple.materialpreference.MaterialPreferenceActivity;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceActionItem;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceCheckBoxItem;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceItemOnClickAction;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceOnCheckedChangedListener;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceSwitchItem;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceTitleItem;
import com.francoisdexemple.materialpreference.model.MaterialPreferenceCard;
import com.francoisdexemple.materialpreference.model.MaterialPreferenceList;

import info.sayederfanarefin.chat.R;

public class Settings extends MaterialPreferenceActivity {

    @Override
    @NonNull
    protected MaterialPreferenceList getMaterialPreferenceList(@NonNull final Context c) {

        //getSupportActionBar().setTitle("Settings");
        changeActiobarDesign();
        final int colorIcon = R.color.colorPrimary;
        MaterialPreferenceCard.Builder appCardBuilder = new MaterialPreferenceCard.Builder();

        // Add items to card

        appCardBuilder.addItem(new MaterialPreferenceTitleItem.Builder()
                .text("Orange Chat")
                .desc("© 2019 Boson 42")
                .icon(R.mipmap.ic_launcher)
                .build());

        appCardBuilder.addItem(ConvenienceBuilder.createVersionActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account_outline)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Version",
                false));

        appCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("Privacy & Policy")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnClickAction(new MaterialPreferenceItemOnClickAction() {
                    @Override
                    public void onClick() {

                    }
                })
                .build());

        appCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("Terms & Condition")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnClickAction(new MaterialPreferenceItemOnClickAction() {
                    @Override
                    public void onClick() {

                    }
                })
                .build());


        MaterialPreferenceCard.Builder preferenceCardBuilder = new MaterialPreferenceCard.Builder();

        preferenceCardBuilder.title("Preferences");

        preferenceCardBuilder.addItem(new MaterialPreferenceSwitchItem.Builder()
                .text("Message Notification")
                .subText("Receive notification for new messages")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_mailbox)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnCheckedChanged(new MaterialPreferenceOnCheckedChangedListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    }
                })
                .setChecked(true)
                .build());

        preferenceCardBuilder.addItem(new MaterialPreferenceSwitchItem.Builder()
                .text("Friends Notification")
                .subText("Receive notification for new friends")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnCheckedChanged(new MaterialPreferenceOnCheckedChangedListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    }
                })
                .setChecked(true)
                .build());

        preferenceCardBuilder.addItem(new MaterialPreferenceSwitchItem.Builder()
                .text("Sound")
                .subText("Playsound when notification is received")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_surround_sound)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnCheckedChanged(new MaterialPreferenceOnCheckedChangedListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    }
                })
                .setChecked(true)
                .build());

        preferenceCardBuilder.addItem(new MaterialPreferenceSwitchItem.Builder()
                .text("Vibrate")
                .subText("Vibrate phone when notification is received")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_vibrate)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnCheckedChanged(new MaterialPreferenceOnCheckedChangedListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    }
                })
                .setChecked(true)
                .build());


        MaterialPreferenceCard.Builder convenienceCardBuilder = new MaterialPreferenceCard.Builder();

        convenienceCardBuilder.title("Orange Chat");

        convenienceCardBuilder.addItem(ConvenienceBuilder.createVersionActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_cellphone)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Version",
                false));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createWebsiteActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_earth)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Visit Website",
                true,
                Uri.parse("http://boson42.tech")));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createRateActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account_star)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Rate this app",
                "Google Play Store"
        ));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createEmailItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_email)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Send an email",
                true,
                "boson.42.apps@gmail.com",
                "Question regarding Orange Chat"));

//        convenienceCardBuilder.addItem(ConvenienceBuilder.createPhoneItem(c,
//                new IconicsDrawable(c)
//                        .icon(CommunityMaterial.Icon.cmd_cellphone)
//                        .color(ContextCompat.getColor(c, colorIcon))
//                        .sizeDp(18),
//                "Call me",
//                true,
//                "+44 12 3456 7890"));

//        convenienceCardBuilder.addItem(ConvenienceBuilder.createMapItem(c,
//                new IconicsDrawable(c)
//                        .icon(CommunityMaterial.Icon.cmd_google_maps)
//                        .color(ContextCompat.getColor(c, colorIcon))
//                        .sizeDp(18),
//                "Visit London",
//                null,
//                "London Eye"));


        MaterialPreferenceCard.Builder authorCardBuilder = new MaterialPreferenceCard.Builder();
        authorCardBuilder.title("Developer");
//        authorCardBuilder.titleColor(ContextCompat.getColor(c, R.color.colorAccent));

        authorCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("Sayed Erfan Arefin")
                .subText("Bangladesh")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .build());






        return new MaterialPreferenceList(appCardBuilder.build(),preferenceCardBuilder.build(), convenienceCardBuilder.build());

    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mp_title_preference);
    }


    private void changeActiobarDesign(){
        // Get the ActionBar
        ActionBar ab = getSupportActionBar();

        // Create a TextView programmatically.
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView

//        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);

        // Set text to display in TextView
        tv.setText("Settings"); // ActionBar title text

        // Set the text color of TextView to red
        // This line change the ActionBar title text color
        tv.setTextColor(getColor(R.color.colorWhite));
        tv.setGravity(Gravity.CENTER);

        // Set the ActionBar display option
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        ab.setHomeAsUpIndicator(upArrow);


        // Finally, set the newly created TextView as ActionBar custom view
        ab.setCustomView(tv);


    }
}