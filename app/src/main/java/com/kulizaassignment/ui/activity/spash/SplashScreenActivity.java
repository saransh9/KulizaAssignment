package com.kulizaassignment.ui.activity.spash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.kulizaassignment.R;
import com.kulizaassignment.data.pojo.Weather;
import com.kulizaassignment.databinding.ActivitySplashscreenBinding;
import com.kulizaassignment.ui.activity.main.MainActivity;
import com.kulizaassignment.ui.base.BaseActivity;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by saransh on 15/03/18.
 */

public class SplashScreenActivity extends BaseActivity implements SplashScreenViewContract {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();

    @Inject
    SplashScreenPresenter presenter;

    ActivitySplashscreenBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        presenter.setView(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splashscreen);
        binding.setClickEvent(this);

        presenter.fetchData();
    }

    @Override
    public void showError() {
        binding.progressBar.setVisibility(View.GONE);
        binding.loadingText.setVisibility(View.GONE);
        binding.errorImage.setVisibility(View.VISIBLE);
        binding.retryButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoader() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.loadingText.setVisibility(View.VISIBLE);
        binding.errorImage.setVisibility(View.GONE);
        binding.retryButton.setVisibility(View.GONE);
    }

    @Override
    public void dataFetched(Weather data, Boolean isErrorFound) {
        if (data != null && !isErrorFound) {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("data",data);
            startActivity(i);
            finish();
        } else
            Log.v(TAG + "datafetch", "something went wrong");
    }



    public void retryButtonClick(View v) {
        presenter.fetchData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.getDisposable().clear();
    }
}
