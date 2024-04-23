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

    @Test
    public void aboutPageVisibilityTest(){
        ActionBar.pressMenuButton();
        ActionBar.pressMenuAbout();
        AboutPage.aboutCompany.check(matches(isDisplayed()));
        AboutPage.aboutVersionText.check(matches(isDisplayed()));
        AboutPage.aboutVersionValue.check(matches(isDisplayed()));
        AboutPage.privacyPolicyText.check(matches(isDisplayed()));
        AboutPage.privacyPolicyLink.check(matches(isDisplayed()));
        AboutPage.termsOfUseText.check(matches(isDisplayed()));
        AboutPage.termsOfUseLink.check(matches(isDisplayed()));
        AboutPage.clickBackButtonAbout();

    }

}
