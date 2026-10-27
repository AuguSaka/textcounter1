
package com.example.textcounter;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.endsWith;

@RunWith(AndroidJUnit4.class)
public class test1 {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    private void calculateAndCheckResult(String text, int metricPosition, int expectedCount) {

        onView(withId(R.id.editTextInput))
                .perform(replaceText(text), closeSoftKeyboard());

        onView(withId(R.id.spinnerMetric)).perform(click());

        onData(anything())
                .atPosition(metricPosition)
                .perform(click());

        onView(withId(R.id.buttonCalculate))
                .perform(click());

        onView(withId(R.id.textViewResult))
                .check(matches(withText(endsWith(": " + expectedCount))));
    }

    @Test
    public void calculateSentenceCount_displaysTwo() {
        calculateAndCheckResult("Labas. Kaip sekasi.", 0, 2);
    }

    @Test
    public void calculateWordCount_displaysThree() {
        calculateAndCheckResult("Vienas du trys", 1, 3);
    }

    @Test
    public void calculatePunctuationCount_displaysThree() {
        calculateAndCheckResult("Labas, pasauli.", 2, 3);
    }

    @Test
    public void calculateNumberCount_displaysTwo() {
        calculateAndCheckResult("Man 12 metu ir 345 dienos", 3, 2);
    }
}
