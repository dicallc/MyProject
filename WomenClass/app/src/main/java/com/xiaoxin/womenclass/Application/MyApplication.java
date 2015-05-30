package com.xiaoxin.womenclass.Application;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2015/5/27 0027.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "c65af339a867ad8d6b124eb1fe4203a0");
    }
}
