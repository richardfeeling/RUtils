package rutils.com.utils;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Author: richardlee on 2018/4/24.
 * Email: richardfeeling@sina.com
 */

public class ToastUtils {

    private static final int toastBg = R.drawable.toast_bg;
    private static final int textColor = R.color.color_white;

    private ToastUtils() {
        throw new UnsupportedOperationException("ToastUtils can't instantiate me.");
    }

    public static void showToast(String tip) {
        showToast(tip, toastBg, textColor);
    }

    public static void showToast(String tip, @DrawableRes int toastBg, @ColorRes int textColor) {
        Context context = ContextUtils.getContext();
        Toast toast = Toast.makeText(context, tip, Toast.LENGTH_SHORT);
        toast.getView().setBackground(ContextUtils.getDrawable(toastBg));
        TextView textView = toast.getView().findViewById(android.R.id.message);
        int screenWidth = ContextUtils.screenWidth();
        textView.setWidth(screenWidth - 50);
        textView.setHeight(ContextUtils.dp2px(45));
        textView.setPadding(0, ContextUtils.dp2px(10),
                0, ContextUtils.dp2px(10));
        textView.setTextSize(14);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(ContextUtils.getColor(textColor));
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


}
