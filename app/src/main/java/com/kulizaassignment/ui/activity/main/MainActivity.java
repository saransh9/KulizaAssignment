package com.kulizaassignment.ui.activity.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.kulizaassignment.R;
import com.kulizaassignment.data.pojo.Weather;
import com.kulizaassignment.databinding.ActivityMainBinding;
import com.kulizaassignment.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityViewContract {

    ActivityMainBinding binding;

    Weather weatherData;

    @Inject
    MainActivityPresenter presenter;

    LinearLayoutManager layoutManager;

    private static Boolean SHEET_EXPANDED = false;

    private static int INITIAL_HEIGHT_VIEW, MARGIN_TOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getActivityComponent().inject(this);

        presenter.setView(this);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            weatherData = (Weather) data.getParcelable("data");
        }

        binding.setData(weatherData);
        Adapter adapter = new Adapter(this, weatherData);
        binding.recycler.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recycler.setLayoutManager(layoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerOnTouch();
        INITIAL_HEIGHT_VIEW = ((ViewGroup.MarginLayoutParams) binding.recycler.getLayoutParams()).topMargin;

    }


    void recyclerOnTouch() {

        binding.recycler.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int a = layoutManager.findLastCompletelyVisibleItemPosition();
                // Log.v("views initial", String.valueOf(INITIAL_HEIGHT_VIEW));
                // Log.v("views initial", String.valueOf(((ViewGroup.MarginLayoutParams) binding.recycler.getLayoutParams()).topMargin));
                MARGIN_TOP = ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).topMargin;

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    binding.recycler.startAnimation(slideUpAnimation(binding.recycler));
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == 5)
                        SHEET_EXPANDED = true;
                    else if (INITIAL_HEIGHT_VIEW >= ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).topMargin)
                        SHEET_EXPANDED = false;
                }
                return true;
            }
        });
    }


    Animation slideUpAnimation(final RecyclerView v) {
        final Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {


                ViewGroup.MarginLayoutParams marginLayoutParams =
                        (ViewGroup.MarginLayoutParams) binding.recycler.getLayoutParams();

                if (layoutManager.findLastCompletelyVisibleItemPosition() < 5 && !SHEET_EXPANDED) {
                    marginLayoutParams.setMargins(0, (int) (MARGIN_TOP - 30), 0, 0);
                    v.setLayoutParams(marginLayoutParams);
                    MARGIN_TOP = MARGIN_TOP - 30;
                } else if (INITIAL_HEIGHT_VIEW >= MARGIN_TOP && SHEET_EXPANDED) {
                    if (MARGIN_TOP + 30 > INITIAL_HEIGHT_VIEW) {
                        marginLayoutParams.setMargins(0, (int) (INITIAL_HEIGHT_VIEW), 0, 0);
                        MARGIN_TOP = INITIAL_HEIGHT_VIEW;
                    } else {
                        marginLayoutParams.setMargins(0, (int) (MARGIN_TOP + 30), 0, 0);
                        MARGIN_TOP = MARGIN_TOP + 30;
                    }
                    v.setLayoutParams(marginLayoutParams);
                }
            }
        };
        animation.setDuration(120);
        animation.setInterpolator(new AccelerateInterpolator());

        return animation;
    }


}
