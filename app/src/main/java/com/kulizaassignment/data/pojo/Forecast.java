package com.kulizaassignment.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by saransh on 15/03/18.
 */

public class Forecast implements Parcelable
{
    private Forecastday[] forecastday;

    protected Forecast(Parcel in) {
        forecastday = in.createTypedArray(Forecastday.CREATOR);
    }

    public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(forecastday, flags);
    }
}

