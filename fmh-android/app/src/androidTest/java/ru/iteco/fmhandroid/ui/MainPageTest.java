package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.MainPage;
import ru.iteco.fmhandroid.ui.pageobjects.NewsPage;
import ru.iteco.fmhandroid.ui.testutils.TestBaseLogin;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainPageTest extends TestBaseLogin {
    MainPage mainPage = new MainPage();
    ActionBar actionBar = new ActionBar();


    @Test
    public void newsMainPageTest() {
        int itemPos = 0;
        mainPage.pressExpand();
        mainPage.pressExpand();
        mainPage.pressExpandNews(0);
        mainPage.pressExpandNews(0);
        mainPage.pressAllNews();
        mainPage.getNewsContainer().check(matches(isDisplayed()));
        actionBar.pressMenuButton();
        actionBar.pressMenuMain();
        mainPage.pressExpandNews(0);
        mainPage.pressExpandNews(0);
        mainPage.getNewsItemDescription(0).check(matches(not(isDisplayed())));
    }

}
