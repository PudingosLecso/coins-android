package com.nothingmagical.coins;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by András on 2017. 05. 02..
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule public final ActivityRule<MainActivity> main = new ActivityRule<MainActivity>(MainActivity.class);

    @Test
    public void testMainPageLayout(){
        onView(withId(R.id.updatedAtLabel)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.btcLabel)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.valueLabel)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void testChangeBtcValue(){
        onView(withId(R.id.btcLabel)).perform(click());
        onView(withId(R.id.textField)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.textField)).perform(replaceText("52"));
        pressBack();
    }

    @Test
    public void testChangeCurrencyToEuro(){
        onView(withId(R.id.valueLabel)).perform(click());
        onView(withText("Euro")).perform(click());
    }
}