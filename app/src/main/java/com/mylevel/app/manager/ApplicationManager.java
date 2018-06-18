package com.mylevel.app.manager;

import android.app.Application;
import android.content.Context;

public class ApplicationManager extends Application {

    //Static Properties
    private static Context _Context;

    public static Context getContext() {
        return _Context;
    }

    public static ApplicationManager getInstance() {
        return (ApplicationManager) _Context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _Context = getApplicationContext();

    }
}
