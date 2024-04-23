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


    @Test
    public void newsMainPageTest(){
        int itemPos = 0;
        MainPage.pressExpand();
        MainPage.pressExpand();
        MainPage.pressExpandNews(0);
        MainPage.pressExpandNews(0);
        MainPage.pressAllNews();
        MainPage.newsContainer.check(matches(isDisplayed()));
        ActionBar.pressMenuButton();
        ActionBar.pressMenuMain();
        MainPage.pressExpandNews(0);
        MainPage.pressExpandNews(0);
        MainPage.newsItemDescription(0).check(matches(not(isDisplayed())));
    }

}
