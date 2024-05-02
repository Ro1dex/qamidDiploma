package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import androidx.test.filters.LargeTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.LoginPage;
import ru.iteco.fmhandroid.ui.testutils.Matchers;
import ru.iteco.fmhandroid.ui.testutils.TestHelper;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ValidLoginTest extends Matchers {
    TestHelper testHelper = new TestHelper();
    LoginPage loginPage = new LoginPage();
    ActionBar actionBar = new ActionBar();

    String validLogin = "login2";
    String validPassword = "password2";

    @Test
    public void appValidLoginTest() {
        testHelper.logoutIfNeeded();
        loginPage.inputLoginString(validLogin);
        loginPage.inputPasswordString(validPassword);
        loginPage.pressLoginButton();
        actionBar.getImageTradeMark().check(matches(isDisplayed()));
    }
    @Test
    public void appTestLogout() {
        testHelper.loginIfNeeded();
        actionBar.pressProfileButton();
        actionBar.pressLogoutButton();
        loginPage.getLoginButton().check(matches(isDisplayed()));

    }

}
