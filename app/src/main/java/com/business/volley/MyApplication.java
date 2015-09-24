package com.business.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by User on 25/09/2015.
 */
public class MyApplication extends Application {
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static MyApplication getInstace()
    {
        return mInstance;
    }

    public static Context getAppContext()
    {
        return mInstance.getApplicationContext();
    }
}
