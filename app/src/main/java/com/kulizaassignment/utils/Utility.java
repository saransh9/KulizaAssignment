package com.kulizaassignment.utils;

import android.util.Log;

import com.kulizaassignment.data.pojo.Forecastday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 * Created by saransh on 16/03/18.
 */

public class Utility {
    public static Forecastday DateFormating(Forecastday data) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(data.getDate());
            String newstring = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(date);


            Date curretnDate = new Date();
            Long time = curretnDate.getTime() + 24 * 60 * 60 * 1000;
            Date tomorrow = new Date(time);

            String currentDate = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(curretnDate);
            String tomorrowString = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(tomorrow);


            if (newstring.equalsIgnoreCase(currentDate))
                data.setDate("Today");
            else if (newstring.equalsIgnoreCase(tomorrowString))
                data.setDate("Tomorrow");
            else
                data.setDate(newstring);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
