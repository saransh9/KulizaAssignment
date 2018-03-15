package com.kulizaassignment.di.component;

import android.app.Application;
import android.content.Context;

import com.kulizaassignment.di.Scope.ActivityContext;
import com.kulizaassignment.di.Scope.PerActivity;
import com.kulizaassignment.di.module.ActivityModule;
import com.kulizaassignment.ui.activity.main.MainActivity;

import dagger.Component;

/**
 * Created by saransh on 15/03/18.
 */

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    @ActivityContext
    Context getContext();

    void inject(MainActivity mainActivity);

}
