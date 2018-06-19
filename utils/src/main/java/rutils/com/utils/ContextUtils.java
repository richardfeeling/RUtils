package rutils.com.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

public class ContextUtils {

    private static Context context;

    private ContextUtils() {
        throw new UnsupportedOperationException("ContextUtils can't instantiate me. ");
    }

    public static void init(Context context) {
        ContextUtils.context = context.getApplicationContext();
    }

    public static Context getContext() {
        if (context != null) {
            return context;
        }
        throw new NullPointerException("ContextUtils should init in your Application");
    }

    public static int getColor(@ColorRes int colorId) {
        return ContextCompat.getColor(context, colorId);
    }

    public static String getString(@StringRes int stringId) {
        return context.getString(stringId);
    }

    public static Drawable getDrawable(@DrawableRes int drawableId) {
        return context.getDrawable(drawableId);
    }

    public static String appVersionName() {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {

        }
        return "";
    }


    public static int appVersionCode() {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {

        }
        return 0;
    }
}
