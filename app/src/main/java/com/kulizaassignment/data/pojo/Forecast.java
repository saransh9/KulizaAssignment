package com.kulizaassignment.data.pojo;

/**
 * Created by saransh on 15/03/18.
 */

public class Forecast
{
    private Forecastday[] forecastday;

    public Forecastday[] getForecastday ()
    {
        return forecastday;
    }

    public void setForecastday (Forecastday[] forecastday)
    {
        this.forecastday = forecastday;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [forecastday = "+forecastday+"]";
    }
}

