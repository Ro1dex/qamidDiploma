package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.TestBase;

public class CreateNews extends TestBase {
    static ViewInteraction newsCategory = onView(
            allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
    public static void pressNewsCategory(){
        Allure.step("Нажатие на 'категория'"); newsCategory.perform(click());
    }
    static DataInteraction category(int pos){ return onData(anything())
            .inRoot(isPlatformPopup())
            .atPosition(pos);
    }
    public static void pressCategory (int pos){Allure.step("Выбор из списка категорий"); category(pos).perform(click());}
    static ViewInteraction createDate = onView(
            allOf(withId(R.id.news_item_publish_date_text_input_edit_text),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.news_item_create_date_text_input_layout),
                                    0),
                            1)));

    public static void pressDate(){Allure.step("Нажатие на 'Дата опубликации'"); createDate.perform(click());}
    static ViewInteraction okButton = onView(
            allOf(withId(android.R.id.button1),
                    childAtPosition(
                            childAtPosition(
                                    withClassName(is("android.widget.ScrollView")),
                                    0),
                            3)));
    static ViewInteraction cancelButton = onView((allOf(withId(android.R.id.button2),  childAtPosition(
            childAtPosition(
                    withId(androidx.constraintlayout.widget.R.id.buttonPanel),
                    0),
            2))));
    public static void pressOk(){Allure.step("Нажатие Ок"); okButton.perform(click());}
    public static void pressCancel(){Allure.step("Нажатие отмена"); cancelButton.perform(click());}
    static ViewInteraction createTime = onView(
            allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.news_item_publish_time_text_input_layout),
                                    0),
                            1)));
    public static void pressTime(){Allure.step("Нажатие на время опубликации"); createTime.perform(click());}
    static ViewInteraction textDescription =onView(allOf(withId(R.id.news_item_description_text_input_edit_text)));

    public static void inputTextDescription(String des){
        Allure.step("Вставка описания");
        textDescription.perform(replaceText(des), closeSoftKeyboard());
    }
    static ViewInteraction dismiss = onView(allOf(withId(R.id.cancel_button)));
    public static void pressDismiss(){Allure.step("Нажатие на отмену изменений"); dismiss.perform(click());}
    static ViewInteraction saveNewsButton = onView(
            allOf(withId(R.id.save_button)));
    public static void pressSave(){Allure.step("Нажатие на сохранить"); saveNewsButton.perform(scrollTo(), click());}
}
