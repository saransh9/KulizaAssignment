package com.kulizaassignment.ui.activity.spash;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by saransh on 15/03/18.
 */

public interface SplashScreenPresenterContract {

    void fetchData();

    CompositeDisposable getDisposable();
}
