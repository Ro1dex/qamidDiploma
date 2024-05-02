package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.Matchers;

public class OurMissionPage extends Matchers {
    ViewInteraction title = onView(
            allOf(withId(R.id.our_mission_title_text_view)));
    ViewInteraction item = onView(
            allOf(withId(R.id.our_mission_item_list_recycler_view)));
    public ViewInteraction getTitle(){
        return title;
    }

    @Step("Нажатие на классную цитату")
    public void pressItem(int position) {
        Allure.step("Нажатие на классную цитату");
        item.perform(actionOnItemAtPosition(position, click()));
    }

}
