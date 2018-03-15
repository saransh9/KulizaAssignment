package com.kulizaassignment.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by saransh on 15/03/18.
 */

public class Astro implements Parcelable
{
    private String moonset;

    private String sunset;

    private String sunrise;

    private String moonrise;

    protected Astro(Parcel in) {
        moonset = in.readString();
        sunset = in.readString();
        sunrise = in.readString();
        moonrise = in.readString();
    }

    public static final Creator<Astro> CREATOR = new Creator<Astro>() {
        @Override
        public Astro createFromParcel(Parcel in) {
            return new Astro(in);
        }

        @Override
        public Astro[] newArray(int size) {
            return new Astro[size];
        }
    };

    public String getMoonset ()
    {
        return moonset;
    }

    public void setMoonset (String moonset)
    {
        this.moonset = moonset;
    }

    public String getSunset ()
    {
        return sunset;
    }

    public void setSunset (String sunset)
    {
        this.sunset = sunset;
    }

    public String getSunrise ()
    {
        return sunrise;
    }

    public void setSunrise (String sunrise)
    {
        this.sunrise = sunrise;
    }

    public String getMoonrise ()
    {
        return moonrise;
    }

    public void setMoonrise (String moonrise)
    {
        this.moonrise = moonrise;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [moonset = "+moonset+", sunset = "+sunset+", sunrise = "+sunrise+", moonrise = "+moonrise+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(moonset);
        dest.writeString(sunset);
        dest.writeString(sunrise);
        dest.writeString(moonrise);
    }
}
