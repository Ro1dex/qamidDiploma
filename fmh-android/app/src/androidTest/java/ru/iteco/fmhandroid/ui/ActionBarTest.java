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
    private final ActionBar actionBar = new ActionBar();
    private final AboutPage aboutPage = new AboutPage();
    private final NewsPage newsPage = new NewsPage();
    private final MainPage mainPage = new MainPage();
    private final OurMissionPage ourMissionPage = new  OurMissionPage();

    @Test
    public void actionBarMenuTest(){
        actionBar.pressMenuButton();
        actionBar.pressMenuAbout();
        aboutPage.getAboutVersionText().check(matches(isDisplayed()));
        aboutPage.clickBackButtonAbout();
        actionBar.pressMenuButton();
        actionBar.pressMenuNews();
        newsPage.getNewsContainer().check(matches(isDisplayed()));
        actionBar.pressMenuButton();
        actionBar.pressMenuMain();
        mainPage.getNewsContainerMain().check(matches(isDisplayed()));
        actionBar.pressMenuButton();
        actionBar.pressMenuNews();
        mainPage.getNewsContainer().check(matches(isDisplayed()));
        actionBar.pressMenuButton();
        actionBar.pressMenuAbout();
        aboutPage.getAboutVersionText().check(matches(isDisplayed()));
    }
    @Test
    public void actionBarOurMissionButtonTest(){
        actionBar.pressOurMissionButton();
        ourMissionPage.getTitle().check(matches(isDisplayed()));
        ourMissionPage.pressItem(0);
        ourMissionPage.pressItem(0);
    }


}
