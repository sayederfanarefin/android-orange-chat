package info.sayederfanarefin.chat.commons;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.model.Settings;
import info.sayederfanarefin.chat.model.users;

public class SharedPrefs {
    Context context;
    public SharedPrefs(Context context){
        this.context = context;
    }
    public void saveUserInSharedPref(users currentUser){
        SharedPreferences mPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(currentUser);
        prefsEditor.putString(context.getString(R.string.sharedPrefCurrentUser), json);
        prefsEditor.commit();
    }

    public users getUserFromSharedPref(){
        Gson gson = new Gson();
        SharedPreferences mPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        String json = mPrefs.getString(context.getString(R.string.sharedPrefCurrentUser), "");
        return gson.fromJson(json, users.class);
    }

    public void saveStringInSharedPref(String tag, String text){
        SharedPreferences mPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        prefsEditor.putString(tag, text);
        prefsEditor.commit();
    }

    public Settings getSettingsFromSharedPref(){
        Gson gson = new Gson();
        SharedPreferences mPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        String json = mPrefs.getString(context.getString(R.string.sharedPrefSettings), "");
        return gson.fromJson(json, Settings.class);
    }

    public void saveSettingsInSharedPref(Settings settings){
        SharedPreferences mPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(settings);
        prefsEditor.putString(context.getString(R.string.sharedPrefSettings), json);
        prefsEditor.commit();
    }

    public String getStringFromSharedPref(String tag, String def) {

        SharedPreferences mPrefs =context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        return mPrefs.getString(tag, def);

    }
//    public void saveFirebaseUserInSharedPref(FirebaseUser currentUser) {
//        SharedPreferences mPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
//        SharedPreferences.Editor prefsEditor = mPrefs.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(currentUser);
//        prefsEditor.putString(context.getString(R.string.sharedPrefCurrentFirebaseUser), json);
//        prefsEditor.commit();
//    }
//
//    public FirebaseUser getFirebaseUserFromSharedPref() {
//        Gson gson = new Gson();
//        SharedPreferences mPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
//        String json = mPrefs.getString(context.getString(R.string.sharedPrefCurrentFirebaseUser), "");
//        return gson.fromJson(json, FirebaseUser.class);
//    }


    public void defaultSettings(){
        info.sayederfanarefin.chat.model.Settings settings = new info.sayederfanarefin.chat.model.Settings();
        settings.setVibrate(true);
        settings.setSound(true);
        settings.setNewFriendsNotification(true);
        settings.setMessageNotification(true);
        saveSettingsInSharedPref(settings);
    }
}
