package com.example.courseregistration;

import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by lantaodong on 2018-03-10.
 */

public class CScourseDescriptionTest {
    @Rule
    public ActivityTestRule<ComputerScienceCourses> mActivityTestRule = new ActivityTestRule<>(ComputerScienceCourses.class);
    @Test
    public void CScourseDescriptionTest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        onData(anything()).inAdapterView(withId(R.id.CS)).atPosition(0).perform(click());
        onView(withId(R.id.CSdescription)).check(matches(isDisplayed()));



    }
}
