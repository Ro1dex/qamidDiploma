package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.pageobjects.ActionBar.imageTradeMark;
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
    String validLogin = "login2";
    String validPassword = "password2";

    @Test
    public void appValidLoginTest() {
        TestHelper.logoutIfNeeded();
        LoginPage.inputLoginString(validLogin);
        LoginPage.inputPasswordString(validPassword);
        LoginPage.pressLoginButton();
        imageTradeMark.check(matches(isDisplayed()));
    }
    @Test
    public void appTestLogout() {
        TestHelper.loginIfNeeded();
        ActionBar.pressProfileButton();
        ActionBar.pressLogoutButton();
        LoginPage.loginButton.check(matches(isDisplayed()));

    }

}
