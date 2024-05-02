package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;


import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.Matchers;

public class AboutPage extends Matchers {
    ViewInteraction aboutVersionText = onView(
            allOf(withId(R.id.about_version_title_text_view)));
    public ViewInteraction getAboutVersionText(){
        return aboutVersionText;
    }

    ViewInteraction backButtonAbout = onView(
            allOf(withId(R.id.about_back_image_button)));

    @Step("Нажатие кнопки назад")
    public void clickBackButtonAbout() {
        Allure.step("Нажатие кнопки назад");
        backButtonAbout.perform(click());
    }

    ViewInteraction aboutCompany = onView(
            allOf(withId(R.id.about_company_info_label_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public ViewInteraction getAboutCompany(){
        return aboutCompany;
    }
    ViewInteraction aboutVersionValue = onView(
            allOf(withId(R.id.about_version_value_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public ViewInteraction getAboutVersionValue(){
        return aboutVersionValue;
    }
    ViewInteraction privacyPolicyText = onView(
            allOf(withId(R.id.about_privacy_policy_label_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public ViewInteraction getPrivacyPolicyText(){
        return privacyPolicyText;
    }

    ViewInteraction privacyPolicyLink = onView(
            allOf(withId(R.id.about_privacy_policy_value_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public ViewInteraction getPrivacyPolicyLink(){
        return privacyPolicyLink;
    }
    ViewInteraction termsOfUseText = onView(
            allOf(withId(R.id.about_terms_of_use_label_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public ViewInteraction getTermsOfUseText(){
        return termsOfUseText;
    }
    ViewInteraction termsOfUseLink = onView(
            allOf(withId(R.id.about_terms_of_use_value_text_view),
                    withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));
    public ViewInteraction getTermsOfUseLink(){
        return termsOfUseLink;
    }

}
