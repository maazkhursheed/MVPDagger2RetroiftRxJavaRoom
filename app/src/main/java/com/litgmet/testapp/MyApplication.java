package com.litgmet.testapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.litgmet.testapp.di.component.ApplicationComponent;
import com.litgmet.testapp.di.component.DaggerApplicationComponent;
import com.litgmet.testapp.di.module.ContextModule;


public class MyApplication extends Application {

    ApplicationComponent applicationComponent;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);
        MyApplication.context = getApplicationContext();

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}

