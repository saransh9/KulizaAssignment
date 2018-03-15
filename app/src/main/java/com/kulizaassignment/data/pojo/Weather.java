package com.kulizaassignment.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by saransh on 15/03/18.
 */

public class Weather implements Parcelable
{
    private Forecast forecast;

    private Location location;

    private Current current;

    protected Weather(Parcel in) {
        forecast = in.readParcelable(Forecast.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        current = in.readParcelable(Current.class.getClassLoader());
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public Forecast getForecast ()
    {
        return forecast;
    }

    public void setForecast (Forecast forecast)
    {
        this.forecast = forecast;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public Current getCurrent ()
    {
        return current;
    }

    public void setCurrent (Current current)
    {
        this.current = current;
    }

    @Override
    public String toString()
    {
        return "Weather [forecast = "+forecast+", location = "+location+", current = "+current+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(forecast, flags);
        dest.writeParcelable(location, flags);
        dest.writeParcelable(current, flags);
    }
}