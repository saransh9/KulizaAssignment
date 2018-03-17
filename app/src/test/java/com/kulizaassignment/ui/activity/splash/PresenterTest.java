package com.kulizaassignment.ui.activity.splash;

import com.kulizaassignment.data.ApiCalls;
import com.kulizaassignment.data.pojo.Weather;
import com.kulizaassignment.ui.activity.spash.SplashScreenActivity;
import com.kulizaassignment.ui.activity.spash.SplashScreenPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by saransh on 17/03/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    private
    ApiCalls apiCalls;

    private SplashScreenPresenter presenter;
    @Mock
    private
    SplashScreenActivity activity;


    @Before
    public void SetUp() {
        presenter = new SplashScreenPresenter(apiCalls);
        presenter.setView(activity);

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Test
    public void dataFetchTestError() {

        when(apiCalls.fetchweather(anyString())).thenReturn(Observable.<Weather>error(new IOException()));

        presenter.fetchData();
        verify(activity).showLoader();
        verify(activity).showError();
        verify(activity).dataFetched(null, true);

    }

    @Test
    public void dataFetchTestSuccess() {

        Weather weather = new Weather();
        when(apiCalls.fetchweather(anyString())).thenReturn(Observable.just(weather));

        presenter.fetchData();
        verify(activity).showLoader();
        verify(activity).dataFetched(weather, false);


    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.reset();
    }
}
