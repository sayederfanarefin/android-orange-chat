package info.sayederfanarefin.chat.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.widget.CompoundButton;
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

        final int colorIcon = R.color.colorPrimary;
        MaterialPreferenceCard.Builder appCardBuilder = new MaterialPreferenceCard.Builder();

        // Add items to card

        appCardBuilder.addItem(new MaterialPreferenceTitleItem.Builder()
                .text("Material Preference Library")
                .desc("© 2018 François Dexemple")
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
                .text("Changelog")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_av_timer)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnClickAction(ConvenienceBuilder.createWebViewDialogOnClickAction(c, "Releases", "https://github.com/daniel-stoneuk/material-Preference-library/releases", true, false))
                .build());

        appCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("Licenses")
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
                .text("Switch")
                .subText("Description of the switch")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_access_point)
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
                .text("Switch2")
                .subText("Description of the switch2")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnCheckedChanged(new MaterialPreferenceOnCheckedChangedListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(c,"Now : "+isChecked,Toast.LENGTH_SHORT).show();
                    }
                })
                .build());

        preferenceCardBuilder.addItem(new MaterialPreferenceCheckBoxItem.Builder()
                .text("CheckBox")
                .subText("Description of the checkbox")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_github_circle)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnCheckedChanged(new MaterialPreferenceOnCheckedChangedListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(c,"Now : "+isChecked,Toast.LENGTH_SHORT).show();
                    }
                })
                .setChecked(true)
                .build());

        MaterialPreferenceCard.Builder convenienceCardBuilder = new MaterialPreferenceCard.Builder();

        convenienceCardBuilder.title("Convenience Builder");

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
                Uri.parse("http://daniel-stone.uk")));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createRateActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account_star)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Rate this app",
                null
        ));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createEmailItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_email)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Send an email",
                true,
                "apps@daniel-stone.uk",
                "Question concerning MaterialPreferenceLibrary"));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createPhoneItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_cellphone)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Call me",
                true,
                "+44 12 3456 7890"));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createMapItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_google_maps)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Visit London",
                null,
                "London Eye"));

        MaterialPreferenceCard.Builder otherCardBuilder = new MaterialPreferenceCard.Builder();
        otherCardBuilder.title("Other");

        otherCardBuilder.cardColor(Color.parseColor("#7986CB"));

        otherCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_access_point)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .text("HTML Formatted Sub Text")
                .subTextHtml("This is <b>HTML</b> formatted <i>text</i> <br /> This is very cool because it allows lines to get very long which can lead to all kinds of possibilities. <br /> And line breaks. <br /> Oh and by the way, this card has a custom defined background.")
                .setIconGravity(MaterialPreferenceActionItem.GRAVITY_TOP)
                .build()
        );
        MaterialPreferenceCard.Builder authorCardBuilder = new MaterialPreferenceCard.Builder();
        authorCardBuilder.title("Author");
//        authorCardBuilder.titleColor(ContextCompat.getColor(c, R.color.colorAccent));

        authorCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("François Dexemple")
                .subText("France")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .build());

        authorCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("Fork on GitHub")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_github_circle)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(c, Uri.parse("https://github.com/filol")))
                .build());

        MaterialPreferenceCard.Builder originalAuthorCardBuilder = new MaterialPreferenceCard.Builder();
        originalAuthorCardBuilder.title("Original author");
//        authorCardBuilder.titleColor(ContextCompat.getColor(c, R.color.colorAccent));

        originalAuthorCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("Daniel Stone")
                .subText("United Kingdom")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .build());

        originalAuthorCardBuilder.addItem(new MaterialPreferenceActionItem.Builder()
                .text("Original Library on GitHub")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_github_circle)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(c, Uri.parse("https://github.com/daniel-stoneuk")))
                .build());


        return new MaterialPreferenceList(appCardBuilder.build(),preferenceCardBuilder.build(), convenienceCardBuilder.build(), otherCardBuilder.build(), authorCardBuilder.build(), originalAuthorCardBuilder.build());

    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mp_title_preference);
    }

}