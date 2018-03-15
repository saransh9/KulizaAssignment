package com.kulizaassignment;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.kulizaassignment.di.component.ApplicationComponent;
import com.kulizaassignment.di.component.DaggerApplicationComponent;
import com.kulizaassignment.di.module.ApiModule;

/**
 * Created by saransh on 15/03/18.
 */

public class ApplicationClass extends Application {
    ApplicationComponent applicationComponent;
    public static final String API_URL = "https://api.apixu.com/";

    public static ApplicationClass get(AppCompatActivity activity) {
        return (ApplicationClass) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .apiModule(new ApiModule(API_URL))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
