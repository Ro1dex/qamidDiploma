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

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.AppActivity;

public class Matchers {
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
    @Step("Matcher по индексу из множества объектов")
    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        Allure.step("Matcher по индексу из множества объектов");
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
    @Step("Matcher отображаемого изображения по id")
    public static Matcher<View> withDrawable(final int resourceId) {
        Allure.step("Matcher отображаемого изображения по id");
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View view) {
                if (!(view instanceof ImageView)) {
                    return false;
                }
                Drawable drawable = ((ImageView) view).getDrawable();
                Resources resources = view.getContext().getResources();
                Drawable expectedDrawable = resources.getDrawable(resourceId);

                return drawable.getConstantState().equals(expectedDrawable.getConstantState());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with drawable from resource id: ");
                description.appendValue(resourceId);
            }
        };
    }
}

