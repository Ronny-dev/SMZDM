package com.ronny.smzdm;

import android.app.Application;

import com.tencent.smtt.sdk.QbSdk;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化X5内核
        QbSdk.initX5Environment(this, null);
    }
}
