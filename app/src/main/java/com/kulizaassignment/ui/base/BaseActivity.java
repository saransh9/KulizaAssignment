package com.kulizaassignment.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kulizaassignment.ApplicationClass;
import com.kulizaassignment.di.Scope.ActivityContext;
import com.kulizaassignment.di.component.ActivityComponent;
import com.kulizaassignment.di.component.DaggerActivityComponent;
import com.kulizaassignment.di.module.ActivityModule;

/**
 * Created by saransh on 15/03/18.
 */

public class BaseActivity extends AppCompatActivity {

    ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(ApplicationClass.get(this).getApplicationComponent())
                .build();

    }

    public ActivityComponent getActivityComponent()
    {
        return activityComponent;
    }
}
