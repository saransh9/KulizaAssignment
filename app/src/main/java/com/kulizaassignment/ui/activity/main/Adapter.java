package com.kulizaassignment.ui.activity.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kulizaassignment.R;
import com.kulizaassignment.data.pojo.Forecastday;
import com.kulizaassignment.data.pojo.Weather;
import com.kulizaassignment.databinding.ItemBinding;
import com.kulizaassignment.utils.Utility;

/**
 * Created by saransh on 15/03/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Weather weatherData;
    private Context context;

    Adapter(Context context, Weather weatherData) {
        this.weatherData = weatherData;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        ItemBinding binding = ItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Forecastday data = weatherData.getForecast().getForecastday()[position];
        holder.bind(Utility.DateFormating(data));
        holder.binding.imageWeather.setImageDrawable(getDrawable(data.getDay().getCondition().getText()));
    }

    @Override
    public int getItemCount() {
        return weatherData.getForecast().getForecastday().length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemBinding binding;

        ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        void bind(Forecastday item) {
            binding.setData(item);
            binding.executePendingBindings();
        }
    }

    private Drawable getDrawable(String name) {
        if (name.contains("cloud"))
            return ContextCompat.getDrawable(context, R.drawable.clouds);
        else if (name.contains("rain"))
            return ContextCompat.getDrawable(context, R.drawable.rain);
        else if (name.contains("sunny"))
            return ContextCompat.getDrawable(context, R.drawable.sun);
        else if (name.contains("thunder"))
            return ContextCompat.getDrawable(context, R.drawable.storm);
        else if (name.contains("clear"))
            return ContextCompat.getDrawable(context, R.drawable.clear);
        else
            return ContextCompat.getDrawable(context, R.drawable.clear);
    }
}
