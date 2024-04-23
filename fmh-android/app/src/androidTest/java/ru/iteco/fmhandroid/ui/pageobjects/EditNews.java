package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class EditNews extends CreateNews{
    static ViewInteraction saveButton =onView(allOf(withId(R.id.save_button)));

    public static void pressSave(){
        Allure.step("Нажатие на сохранить"); saveButton.perform(click());}

    static ViewInteraction textInputDescription = onView(
            allOf(withId(R.id.news_item_description_text_input_edit_text),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.news_item_description_text_input_layout),
                                    0),
                            1)));
    public static void inputEditDescription(String editedDescription){
        textInputDescription.perform(replaceText(editedDescription));
    }
}
