package com.kulizaassignment.ui.activity.main;

import javax.inject.Inject;

/**
 * Created by saransh on 15/03/18.
 */

public class MainActivityPresenter implements MainActivityPresenterContract {


    MainActivity view;

    @Inject
    public MainActivityPresenter()
    {

    }

    public void setView(MainActivity view)
    {
        this.view=view;
    }
}
