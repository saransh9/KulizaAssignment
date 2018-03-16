package com.kulizaassignment.data;

import com.kulizaassignment.data.pojo.Weather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by saransh on 15/03/18.
 */

public interface ApiCalls {

    @GET("v1/forecast.json?q=Bengaluru&days=6")
    Observable<Weather> fetchweather(@Query("key") String key);
}
