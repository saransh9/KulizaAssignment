package com.kulizaassignment.ui.activity.splash;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.kulizaassignment.R;
import com.kulizaassignment.ui.activity.spash.SplashScreenActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.kulizaassignment.test_util.Utils.isConnected;

/**
 * Created by saransh on 17/03/18.
 */
@RunWith(AndroidJUnit4.class)
public class SplashScreenTest {

    @Rule
    public ActivityTestRule<SplashScreenActivity> mActivityRule = new ActivityTestRule<>(
            SplashScreenActivity.class);


    @Test
    public void testProgressbar() {

        if (isConnected(mActivityRule.getActivity())) {
            onView(ViewMatchers.withId(R.id.loadingText))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
            onView(withId(R.id.progressBar))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
            onView(withId(R.id.retryButton))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
            onView(withId(R.id.errorImage))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
        else
        {
            onView(withId(R.id.retryButton))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
            onView(withId(R.id.errorImage))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
            onView(withId(R.id.loadingText))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
            onView(withId(R.id.progressBar))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
    }



}
