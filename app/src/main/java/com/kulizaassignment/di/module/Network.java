package com.kulizaassignment.di.module;

import android.util.Log;

import com.kulizaassignment.di.Scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by saransh on 15/03/18.
 */

@Module
public class Network {

    @Provides
    @ApplicationScope
    HttpLoggingInterceptor loggingInterceptor()
    {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("dagger2", "Log: " + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;

    }

    @Provides
    @ApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggerInterceptor)
    {
        return new OkHttpClient.Builder()
                .addInterceptor(loggerInterceptor)
                .build();

    }
}
