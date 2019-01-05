package info.ankon.template.helpers;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.devspark.appmsg.AppMsg;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.ankon.template.R;

public class UIUtils {

    public static int dpToPx(Context context, int dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void alert(Context context, String msg) {
        alert(context, null, msg);
    }

    public static void alert(Context context, String title, String msg) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    public static void alert(Context context, int layoutRes) {
        new AlertDialog.Builder(context)
                .setView(layoutRes)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    public static void confirm(Context context, String msg, View.OnClickListener listener1, View.OnClickListener listener2) {
        confirm(context, null, msg, listener1,listener2);
    }

    public static void confirm(Context context, String msg, View.OnClickListener listener1) {
        confirm(context, null, msg, listener1);
    }

    public static void confirm(Context context, String title, String msg, View.OnClickListener listener1,View.OnClickListener listener2) {
//        new AlertDialog.Builder(context)
//                .setTitle(title)
//                .setMessage(msg)
//                .setPositiveButton(android.R.string.ok, listener)
//                .setNegativeButton(android.R.string.cancel, listener)
//                .show();
        final NiftyDialogBuilder dialogBuilder= NiftyDialogBuilder.getInstance(context);
        dialogBuilder
                .withTitle(title)
                .withTitleColor(R.color.white)
                .withMessage(msg)
                .withMessageColor("#FFFFFF")
                .withDialogColor("#03A9F4")
                .withDuration(100)
                .withEffect(Effectstype.Fadein)
                .isCancelableOnTouchOutside(false)
                .withButton1Text(context.getResources().getString(android.R.string.ok))
                .withButton2Text(context.getResources().getString(android.R.string.cancel))
                .setButton1Click(listener1)
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogBuilder.cancel();
                    }
                })
                .show();
    }

    public static void confirm(Context context, String title, String msg, View.OnClickListener listener1) {
        final NiftyDialogBuilder dialogBuilder= NiftyDialogBuilder.getInstance(context);
        dialogBuilder
                .withTitle(title)
                .withTitleColor(R.color.white)
                .withMessage(msg)
                .withMessageColor("#FFFFFF")
                .withDialogColor("#03A9F4")
                .withDuration(100)
                .withEffect(Effectstype.Fadein)
                .isCancelableOnTouchOutside(false)
                .withButton1Text(context.getResources().getString(android.R.string.ok))
                .setButton1Click(listener1)
                .show();
    }

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void globalMsg(Activity activity, String msg, ViewGroup containerLayout, AppMsg.Style style) {
        AppMsg appMsg;

        if (style == null || style == AppMsg.STYLE_INFO) {
            appMsg = AppMsg.makeText(activity, msg, new AppMsg.Style(AppMsg.LENGTH_SHORT, R.color.colorPrimary), 16.0f);
        } else {
            appMsg = AppMsg.makeText(activity, msg, style, 16.0f);
        }

        appMsg.setParent(containerLayout);
        appMsg.setLayoutGravity(Gravity.TOP);
        appMsg.show();
    }

}
