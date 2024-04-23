package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.TestBase;

public class FilterNews extends CreateNews {

    static ViewInteraction publishDateStart = onView(
            allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.news_item_publish_date_start_text_input_layout),
                                    0),
                            1)));
    public static void pressDateStart (){
        Allure.step("Нажатие на 'От Даты'"); publishDateStart.perform(click());}

    static ViewInteraction publishDateEnd = onView(
            allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.news_item_publish_date_end_text_input_layout),
                                    0),
                            1)));
    public static void pressDateEnd(){Allure.step("Нажатие на 'До Даты'"); publishDateEnd.perform(click());}
    static ViewInteraction filterButton = onView(
            allOf(withId(R.id.filter_button),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.nav_host_fragment),
                                    0),
                            6)));
    public static void pressFilter(){Allure.step("Нажатие на кнопку фильтра"); filterButton.perform(click());}
}
