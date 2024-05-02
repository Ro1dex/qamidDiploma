package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.pageobjects.AboutPage;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.testutils.TestBaseLogin;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTest extends TestBaseLogin {
    private final AboutPage aboutPage = new AboutPage();
    private final ActionBar actionBar = new ActionBar();
    @Test
    public void aboutPageVisibilityTest(){
        actionBar.pressMenuButton();
        actionBar.pressMenuAbout();
        aboutPage.getAboutCompany().check(matches(isDisplayed()));
        aboutPage.getAboutVersionText().check(matches(isDisplayed()));
        aboutPage.getAboutVersionValue().check(matches(isDisplayed()));
        aboutPage.getPrivacyPolicyText().check(matches(isDisplayed()));
        aboutPage.getPrivacyPolicyLink().check(matches(isDisplayed()));
        aboutPage.getTermsOfUseText().check(matches(isDisplayed()));
        aboutPage.getTermsOfUseLink().check(matches(isDisplayed()));
        aboutPage.clickBackButtonAbout();
    }

}
