package ru.iteco.fmhandroid.ui.testutils;

import static ru.iteco.fmhandroid.ui.EspressoIdlingResources.idlingResource;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import ru.iteco.fmhandroid.ui.AppActivity;

public class TestBase {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Before
    public void registeredIdleResources(){
        IdlingRegistry.getInstance().register(idlingResource);
    }


    @After
    public void unregisteredIdleResources(){
        IdlingRegistry.getInstance().unregister(idlingResource);

    }
}

