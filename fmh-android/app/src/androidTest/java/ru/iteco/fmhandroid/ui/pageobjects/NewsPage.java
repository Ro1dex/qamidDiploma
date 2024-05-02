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

public class NewsPage extends Matchers {
    ViewInteraction newsContainer = onView(
            allOf(withId(R.id.container_list_news_include)));
    public ViewInteraction getNewsContainer(){
        return newsContainer;
    }
    ViewInteraction newsItem = onView(
            allOf(withId(R.id.news_list_recycler_view)));

    @Step("Нажатие на определённую новость")
    public void pressNewsItem(int position) {
        Allure.step("Нажатие на определённую новость");
        newsItem.perform(actionOnItemAtPosition(position, click()));
    }

    ViewInteraction sortNewsButton = onView(
            allOf(withId(R.id.sort_news_material_button)));

    @Step("Нажатие сортировки новостей")
    public void pressSortNews() {
        Allure.step("Нажатие сортировки новостей");
        sortNewsButton.perform(click());
    }

    ViewInteraction filterNewsButton = onView(
            allOf(withId(R.id.filter_news_material_button)));

    @Step("Нажатие на фильтр новостей")
    public void pressFilterNews() {
        Allure.step("Нажатие на фильтр новостей");
        filterNewsButton.perform(click());
    }

    ViewInteraction editNewsButton = onView(
            allOf(withId(R.id.edit_news_material_button)));

    @Step("Нажатие на редактирование списка новостей")
    public void pressEdit() {
        Allure.step("Нажатие на редактирование списка новостей");
        editNewsButton.perform(click());
    }

    ViewInteraction newsItemTitle(int position) {
        return onView(withIndex(withId(R.id.news_item_title_text_view), position));
    }

    public void pressTitle(int position) {
        newsItemTitle(position).perform(click());
    }

     ViewInteraction newsItemDescription(int position) {
        return onView(withIndex(withId(R.id.news_item_description_text_view), position));
    }
    public ViewInteraction getNewsItemDescription(int position){
        return newsItemDescription(position);
    }

    @Step("Нажатие на описание новости")
    public void pressDescription(int position) {
        Allure.step("Нажатие на описание новости");
        newsItemDescription(position).perform(click());
    }

    ViewInteraction newsItemDate(int position) {
        return onView(
                withIndex(withId(R.id.news_item_date_text_view), position));
    }

    ViewInteraction newsItemImageCategory(int position) {
        return onView(
                withIndex(withId(R.id.category_icon_image_view), position));
    }

     ViewInteraction newsItemExpand(int position) {
        return onView(
                withIndex(withId(R.id.view_news_item_image_view), position));
    }

    @Step("Нажатие на значок раскрытия новости")
    public void pressExpandNews(int position) {
        Allure.step("Нажатие на значок раскрытия новости");
        newsItemExpand(position).perform(click());
    }


}
