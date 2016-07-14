package com.example.yejunjie.sugarormdemo;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by yejunjie on 16/7/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
