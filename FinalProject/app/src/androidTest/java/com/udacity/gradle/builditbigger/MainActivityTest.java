package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.utils.NetworkUtils;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends TestCase {

    private IdlingResource mIdlingResource;

    @Rule
    public ActivityTestRule<MainActivity> mMainActivity = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        mIdlingResource = mMainActivity.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @Test
    public void getJokeFromServer(){
        onView(withId(R.id.bt_tell_joke)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_tell_joke)).perform(click());
        if(NetworkUtils.checkInternetConnection(mMainActivity.getActivity().getApplicationContext())){
            onView(withId(R.id.tv_joker)).check(matches(not(withText(isEmptyOrNullString()))));
        } else {
            onView(withId(R.id.in_no_internet)).check(matches(isDisplayed()));
            onView(withId(R.id.in_loading)).check(matches(not(isDisplayed())));
        }

    }
    @After
    public void unregisterIdlingResource(){
        if(mIdlingResource != null){
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }

}