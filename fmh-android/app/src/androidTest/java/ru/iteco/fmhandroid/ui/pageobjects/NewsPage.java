package ru.iteco.fmhandroid.ui.pageobjects;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import androidx.test.espresso.ViewInteraction;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.TestBase;

public class NewsPage extends TestBase {
    public static ViewInteraction newsContainer = onView(
            allOf(withId(R.id.container_list_news_include)));
    static ViewInteraction newsItem = onView(
            allOf(withId(R.id.news_list_recycler_view)));
    public static void pressNewsItem(int position){
        Allure.step("Нажатие на определённую новость");
        newsItem.perform(actionOnItemAtPosition(position, click()));
    }
    static ViewInteraction sortNewsButton = onView(
            allOf(withId(R.id.sort_news_material_button)));
    public static void pressSortNews(){Allure.step("Нажатие сортировки новостей"); sortNewsButton.perform(click());}
    static ViewInteraction filterNewsButton = onView(
            allOf(withId(R.id.filter_news_material_button)));
    public static void pressFilterNews(){Allure.step("Нажатие на фильтр новостей"); filterNewsButton.perform(click());
    }
    static ViewInteraction editNewsButton = onView(
            allOf(withId(R.id.edit_news_material_button)));
    public static void pressEdit(){Allure.step("Нажатие на редактирование новостей"); editNewsButton.perform(click());}

    public static ViewInteraction newsItemTitle(int position){return onView(withIndex(withId(R.id.news_item_title_text_view), position));
    }
    public static void pressTitle(int position){
        newsItemTitle(position).perform(click());
    }
    public static ViewInteraction newsItemDescription(int position) { return onView(withIndex(withId(R.id.news_item_description_text_view), position));
    }
    public static void pressDescription (int position){
        Allure.step("Нажатие на описание новости");
        newsItemDescription(position).perform(click());
    }
    public static ViewInteraction newsItemDate (int position){  return onView(
            withIndex(withId(R.id.news_item_date_text_view), position));}
    public static ViewInteraction newsItemImageCategory (int position) {
        return onView(
                withIndex(withId(R.id.category_icon_image_view), position));
    }
    public static ViewInteraction newsItemExpand (int position) {
        return  onView(
                withIndex(withId(R.id.view_news_item_image_view), position));
    }
    public static void pressExpandNews(int position){
        Allure.step("Нажатие на значок раскрытия новости");
        newsItemExpand(position).perform(click());
    }







}
