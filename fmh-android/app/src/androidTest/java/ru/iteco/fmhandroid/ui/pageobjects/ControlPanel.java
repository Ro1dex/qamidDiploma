package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;


import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class ControlPanel extends NewsPage {
    ViewInteraction addNewsButton = onView(allOf(withId(R.id.add_news_image_view)));
    public ViewInteraction getAddNewsButton(){
        return addNewsButton;
    }

    @Step("Нажатие на 'Добавить новость'")
    public void pressAddNews() {
        Allure.step("Нажатие на 'Добавить новость'");
        addNewsButton.perform(click());
    }

    ViewInteraction deleteNewsButton(int pos) {
        return onView(withIndex(withId(R.id.delete_news_item_image_view), pos));
    }

    @Step("Нажатие на удаление новости")
    public void pressDeleteNews(int pos) {
        Allure.step("Нажатие на удаление новости");
        deleteNewsButton(pos).perform(click());
    }

    ViewInteraction editNews(int pos) {
        return onView(
                withIndex(withId(R.id.edit_news_item_image_view), pos));
    }

    @Step("Нажатие на редатирование новостей")
    public void pressEditNews(int pos) {
        Allure.step("Нажатие на редатирование новостей");
        editNews(pos).perform(click());
    }

}
