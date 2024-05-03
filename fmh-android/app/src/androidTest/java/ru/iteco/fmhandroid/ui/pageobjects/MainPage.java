package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class MainPage extends NewsPage {
    ViewInteraction newsContainerMain = onView(
            allOf((withId(R.id.container_list_news_include_on_fragment_main))));
    public ViewInteraction getNewsContainerMain(){
        return newsContainerMain;
    }
    ViewInteraction newsContainerExpand = onView(
            allOf(withId(R.id.expand_material_button)));

    @Step("Нажатие на раскрытие всех новостей")
    public void pressExpand() {
        Allure.step("Нажатие на раскрытие всех новостей");
        newsContainerExpand.perform(click());

    }

    ViewInteraction allNewsButton = onView(
            allOf(withId(R.id.all_news_text_view)));

    @Step("Нажатие на все новости")
    public void pressAllNews() {
        Allure.step("Нажатие на все новости");
        allNewsButton.perform(click());
    }


}
