package com.rutils;

import android.app.Application;

import rutils.com.utils.RetrofitUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitUtil.init("http://www.baidu.com/");
    }
}
