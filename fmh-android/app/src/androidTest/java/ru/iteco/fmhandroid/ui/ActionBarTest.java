package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.pageobjects.AboutPage;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.MainPage;
import ru.iteco.fmhandroid.ui.pageobjects.NewsPage;
import ru.iteco.fmhandroid.ui.pageobjects.OurMissionPage;
import ru.iteco.fmhandroid.ui.testutils.TestBaseLogin;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ActionBarTest extends TestBaseLogin {

    @Test
    public void actionBarMenuTest(){
        ActionBar.pressMenuButton();
        ActionBar.pressMenuAbout();
        AboutPage.aboutVersionText.check(matches(isDisplayed()));
        AboutPage.clickBackButtonAbout();
        ActionBar.pressMenuButton();
        ActionBar.pressMenuNews();
        NewsPage.newsContainer.check(matches(isDisplayed()));
        ActionBar.pressMenuButton();
        ActionBar.pressMenuMain();
        MainPage.newsContainerMain.check(matches(isDisplayed()));
        ActionBar.pressMenuButton();
        ActionBar.pressMenuNews();
        NewsPage.newsContainer.check(matches(isDisplayed()));
        ActionBar.pressMenuButton();
        ActionBar.pressMenuAbout();
        AboutPage.aboutVersionText.check(matches(isDisplayed()));
    }
    @Test
    public void actionBarOurMissionButtonTest(){
        ActionBar.pressOurMissionButton();
        OurMissionPage.title.check(matches(isDisplayed()));
        OurMissionPage.pressItem(0);
        OurMissionPage.pressItem(0);
    }


}
