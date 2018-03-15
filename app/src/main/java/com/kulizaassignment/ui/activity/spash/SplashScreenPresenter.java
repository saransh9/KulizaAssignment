package com.kulizaassignment.ui.activity.spash;

import android.view.View;

import com.kulizaassignment.data.ApiCalls;
import com.kulizaassignment.data.pojo.Weather;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by saransh on 15/03/18.
 */

public class SplashScreenPresenter implements SplashScreenPresenterContract {

    private SplashScreenActivity view;

    private ApiCalls apiCalls;

    @Inject
    public SplashScreenPresenter(ApiCalls apiCalls) {
        this.apiCalls = apiCalls;
    }

    void setView(SplashScreenActivity view) {
        this.view = view;
    }


    @Override
    public void fetchData() {
        view.showLoader();
        apiCalls.fetchweather("a997b16b788249869e374838181503")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new Observer<Weather>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Weather weather) {
                        if (view != null) {
                            view.dataFetched(weather, false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.showError();
                            view.dataFetched(null,true);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
