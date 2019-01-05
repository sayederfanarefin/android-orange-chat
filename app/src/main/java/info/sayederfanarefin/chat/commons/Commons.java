package info.sayederfanarefin.chat.commons;

import android.Manifest;
import android.content.Context;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commons {

    private Commons() {
    }

    public enum UnitType {FEET, INCH, CM}

    public static int cmFromFeet(int feet) {
        return (int) ((double) feet * 30.48);
    }

    public static int feetFromCm(int cm) {
        return (int) ((double) cm * 0.0328084);
    }

    public static int counterFeetFromCm(int cm) {
        return (inchFromCm(cm) / 12);
    }

    public static int inchFromCm(Integer cm) {
        return (int) Math.round(cm / 2.54);
    }

    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    public static Map<UnitType, Integer> feetAndInchFromCm(int cm) {
        Map<UnitType, Integer> feetMap = new HashMap<>();
        feetMap.put(UnitType.FEET, (int) ((double) cm * 0.0328084));
        feetMap.put(UnitType.INCH, inchFromCm(cm) % 12);
        return feetMap;
    }

    public static int cmFromFeetAndInch(int feet, int inch) {
        double feets = (double) feet + ((double) inch / 12);
        return cmFromFeet((int) feets);
    }

    public static void askPermissions(Context context, PermissionListener permissionListener) {
        new TedPermission(context)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setRationaleMessage("We require some permissions to work smoothly with the medical devices. Please confirm and allow.")
                .setPermissions(Manifest.permission.RECEIVE_SMS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();
    }

    public static boolean NOT_NULL_NOT_EMPTY(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean NULL_OR_EMPTY(String string) {
        return !NOT_NULL_NOT_EMPTY(string);
    }


    public static boolean containsSpecialCharacter(String string) {
        Pattern p = Pattern.compile("[^a-z0-9. ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);
        return m.find();
    }

}