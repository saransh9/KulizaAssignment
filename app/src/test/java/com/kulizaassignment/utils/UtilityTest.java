package com.kulizaassignment.utils;

import com.kulizaassignment.data.pojo.Forecastday;

import org.junit.Test;

import static com.kulizaassignment.test_utils.Utils.initializeData;
import static com.kulizaassignment.utils.Utility.DateFormating;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by saransh on 18/03/18.
 */

public class UtilityTest {

    @Test
    public void dateChangeTestToday()
    {
        Forecastday today = DateFormating(initializeData().getForecast().getForecastday()[0]);
        assertThat(DateFormating(initializeData().getForecast().getForecastday()[0]).getDate(),is(today.getDate()));

        Forecastday tomorrow = DateFormating(initializeData().getForecast().getForecastday()[1]);
        assertThat(DateFormating(initializeData().getForecast().getForecastday()[1]).getDate(),is(tomorrow.getDate()));

        Forecastday others = DateFormating(initializeData().getForecast().getForecastday()[3]);
        assertThat(DateFormating(initializeData().getForecast().getForecastday()[3]).getDate(),is(others.getDate()));
    }
    @Test
    public void dateChangeTestTomorrow()
    {
        Forecastday tomorrow = DateFormating(initializeData().getForecast().getForecastday()[1]);
        assertThat(DateFormating(initializeData().getForecast().getForecastday()[1]).getDate(),is(tomorrow.getDate()));

    }
    @Test
    public void dateChangeTestOthers()
    {

        Forecastday others = DateFormating(initializeData().getForecast().getForecastday()[3]);
        assertThat(DateFormating(initializeData().getForecast().getForecastday()[3]).getDate(),is(others.getDate()));
    }
}
