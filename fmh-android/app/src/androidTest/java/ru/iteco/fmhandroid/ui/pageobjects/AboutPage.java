package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.TestBase;

public class AboutPage extends TestBase {

    public static ViewInteraction aboutVersionText = onView(
            allOf(withId(R.id.about_version_title_text_view)));
    static ViewInteraction backButtonAbout = onView(
            allOf(withId(R.id.about_back_image_button)));
    public static void clickBackButtonAbout(){
        Allure.step("Нажатие кнопки назад"); backButtonAbout.perform(click());
    }
    public static ViewInteraction aboutCompany = onView(
            allOf(withId(R.id.about_company_info_label_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public static ViewInteraction aboutVersionValue = onView(
            allOf(withId(R.id.about_version_value_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public static ViewInteraction privacyPolicyText = onView(
            allOf(withId(R.id.about_privacy_policy_label_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));

    public static ViewInteraction privacyPolicyLink = onView(
            allOf(withId(R.id.about_privacy_policy_value_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public static ViewInteraction termsOfUseText = onView(
            allOf(withId(R.id.about_terms_of_use_label_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public static ViewInteraction termsOfUseLink = onView(
            allOf(withId(R.id.about_terms_of_use_value_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));

}
