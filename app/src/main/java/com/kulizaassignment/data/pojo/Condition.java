package com.kulizaassignment.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by saransh on 15/03/18.
 */

public class Condition implements Parcelable
{
    private String icon;

    private String text;

    private String code;

    protected Condition(Parcel in) {
        icon = in.readString();
        text = in.readString();
        code = in.readString();
    }

    public static final Creator<Condition> CREATOR = new Creator<Condition>() {
        @Override
        public Condition createFromParcel(Parcel in) {
            return new Condition(in);
        }

        @Override
        public Condition[] newArray(int size) {
            return new Condition[size];
        }
    };

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [icon = "+icon+", text = "+text+", code = "+code+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(icon);
        dest.writeString(text);
        dest.writeString(code);
    }
}