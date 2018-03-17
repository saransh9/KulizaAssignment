package com.kulizaassignment.ui.activity.main;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.kulizaassignment.R;
import com.kulizaassignment.test_util.RecyclerViewItemCountAssert;
import com.kulizaassignment.test_util.Utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by saransh on 18/03/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected Intent getActivityIntent() {

            Intent intent = new Intent();
            intent.putExtra("data", Utils.initializeData());
            return intent;
        }
    };

    @Test
    public void testCurrentView() {
        onView(withId(R.id.temperature))
                .check(matches(withText(Utils.initializeData().getCurrent().getTemp_c() + mainActivityActivityTestRule.getActivity().getString(R.string.degree))));
        onView(withId(R.id.city)).check(matches(withText(Utils.initializeData().getLocation().getName())));

    }

    @Test
    public void testRecyclerTouch() {
        onView(withId(R.id.recycler)).perform(swipeDown());
        onView(withId(R.id.recycler)).check(new RecyclerViewItemCountAssert(6));
        onView(withId(R.id.recycler)).perform(swipeDown());
    }

    @Test
    public void testRecylerItem() {

        onView(allOf(withId(R.id.name_weather),withText("Light rain shower"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.name),withText("Tomorrow"))).check(matches(isDisplayed()));

    }


}
