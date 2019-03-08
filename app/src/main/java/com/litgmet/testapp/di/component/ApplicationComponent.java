package com.litgmet.testapp.di.component;

import android.content.Context;


import com.litgmet.testapp.MyApplication;
import com.litgmet.testapp.di.module.ContextModule;
import com.litgmet.testapp.di.module.RetrofitModule;
import com.litgmet.testapp.di.qualifier.ApplicationContext;
import com.litgmet.testapp.di.scopes.ApplicationScope;
import com.litgmet.testapp.network.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
