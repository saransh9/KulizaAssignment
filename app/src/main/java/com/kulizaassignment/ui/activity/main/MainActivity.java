package com.kulizaassignment.ui.activity.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kulizaassignment.R;
import com.kulizaassignment.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
    }
}
