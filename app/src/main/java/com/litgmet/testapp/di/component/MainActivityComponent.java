package com.litgmet.testapp.di.component;

import android.content.Context;

import com.litgmet.testapp.MainActivity;
import com.litgmet.testapp.di.module.AdapterModule;
import com.litgmet.testapp.di.module.MainActivityMvpModule;
import com.litgmet.testapp.di.qualifier.ActivityContext;
import com.litgmet.testapp.di.scopes.ActivityScope;
import dagger.Component;


@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}
