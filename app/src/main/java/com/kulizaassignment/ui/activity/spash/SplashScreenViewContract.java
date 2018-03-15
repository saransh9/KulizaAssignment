package com.kulizaassignment.ui.activity.spash;

import com.kulizaassignment.data.pojo.Weather;

/**
 * Created by saransh on 15/03/18.
 */

public interface SplashScreenViewContract {

    void showError();

    void showLoader();

    void dataFetched(Weather data,Boolean isErrorFound);




}
