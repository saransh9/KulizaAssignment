package com.kulizaassignment.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by saransh on 15/03/18.
 */

public class Forecastday implements Parcelable
{
    private Astro astro;

    private Day day;

    private String date;

    private String date_epoch;

    protected Forecastday(Parcel in) {
        astro = in.readParcelable(Astro.class.getClassLoader());
        day = in.readParcelable(Day.class.getClassLoader());
        date = in.readString();
        date_epoch = in.readString();
    }

    public static final Creator<Forecastday> CREATOR = new Creator<Forecastday>() {
        @Override
        public Forecastday createFromParcel(Parcel in) {
            return new Forecastday(in);
        }

        @Override
        public Forecastday[] newArray(int size) {
            return new Forecastday[size];
        }
    };

    public Astro getAstro ()
    {
        return astro;
    }

    public void setAstro (Astro astro)
    {
        this.astro = astro;
    }

    public Day getDay ()
    {
        return day;
    }

    public void setDay (Day day)
    {
        this.day = day;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getDate_epoch ()
    {
        return date_epoch;
    }

    public void setDate_epoch (String date_epoch)
    {
        this.date_epoch = date_epoch;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [astro = "+astro+", day = "+day+", date = "+date+", date_epoch = "+date_epoch+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(astro, flags);
        dest.writeParcelable(day, flags);
        dest.writeString(date);
        dest.writeString(date_epoch);
    }
}
