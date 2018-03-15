package com.kulizaassignment.di.component;

import com.kulizaassignment.ApplicationClass;
import com.kulizaassignment.data.ApiCalls;
import com.kulizaassignment.di.Scope.ApplicationScope;
import com.kulizaassignment.di.module.ApiModule;
import com.kulizaassignment.di.module.Network;

import dagger.Component;

/**
 * Created by saransh on 15/03/18.
 */

@ApplicationScope
@Component(modules = {ApiModule.class})
public interface ApplicationComponent {

    void inject(ApplicationClass applicationClass);

    ApiCalls getapiCalls();
}
