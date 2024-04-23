package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.ControlPanel;
import ru.iteco.fmhandroid.ui.pageobjects.CreateNews;
import ru.iteco.fmhandroid.ui.pageobjects.EditNews;
import ru.iteco.fmhandroid.ui.pageobjects.FilterNews;
import ru.iteco.fmhandroid.ui.pageobjects.MainPage;
import ru.iteco.fmhandroid.ui.pageobjects.NewsPage;
import ru.iteco.fmhandroid.ui.testutils.CheckImageNewsIsDisplayed;
import ru.iteco.fmhandroid.ui.testutils.TestBaseLogin;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTest extends TestBaseLogin {


    @Test
    public void newsPageTest(){
        ActionBar.pressMenuButton();
        ActionBar.pressMenuNews();
        NewsPage.pressSortNews();
        NewsPage.pressSortNews();
        NewsPage.pressFilterNews();
        FilterNews.pressDismiss();
        NewsPage.pressEdit();
        ControlPanel.addNewsButton.check(matches(isDisplayed()));
        Espresso.pressBack();
        NewsPage.newsContainer.check(matches(isDisplayed()));
        NewsPage.pressExpandNews(0);
        NewsPage.pressDescription(0);
        NewsPage.pressDescription(0);
        NewsPage.pressExpandNews(0);
    }
    @Test
    public void createAndDeleteNewsTest(){
        String description = "Эта новость сделана автоматически";
        int position = 0;
        MainPage.pressAllNews();
        NewsPage.pressEdit();
        ControlPanel.pressAddNews();
        CreateNews.pressNewsCategory();
        CreateNews.pressCategory(position);
        CreateNews.pressDate();
        CreateNews.pressOk();
        CreateNews.pressTime();
        CreateNews.pressOk();
        CreateNews.inputTextDescription(description);
        CreateNews.pressSave();

        ActionBar.pressMenuButton();
        ActionBar.pressMenuNews();
        NewsPage.pressNewsItem(position);
        NewsPage.newsItemDescription(position).check(matches(withText(description)));
        NewsPage.pressEdit();
        NewsPage.pressNewsItem(position);
        NewsPage.newsItemDescription(position).check(matches(withText(description)));
        ControlPanel.pressDeleteNews(position);
        CreateNews.pressOk();
        ActionBar.pressMenuButton();
        ActionBar.pressMenuMain();
        NewsPage.newsItemDescription(position).check(matches(not(withText(description))));

    }
    @Test
    public void filterNewsTest(){
        int categoryPos = 0;
        MainPage.pressAllNews();
        NewsPage.pressFilterNews();

        FilterNews.pressNewsCategory();
        FilterNews.pressCategory(categoryPos);
        FilterNews.pressDateStart();
        CreateNews.pressOk();
        FilterNews.pressDateEnd();
        CreateNews.pressOk();
        FilterNews.pressFilter();
        CheckImageNewsIsDisplayed.chosePosition(categoryPos);
    }
    @Test
    public void editNewsTest(){
        int itemPos = 0;
        MainPage.pressAllNews();
        NewsPage.pressEdit();
        ControlPanel.pressEditNews(itemPos);
        String editedDescription = "Автоматически изменённое описание 1";
        EditNews.pressDismiss();
        EditNews.pressOk();
        ControlPanel.pressEditNews(0);
        EditNews.pressDismiss();
        EditNews.pressCancel();
        EditNews.inputEditDescription(editedDescription);
        EditNews.pressSave();
        NewsPage.newsItemDescription(itemPos).check(matches(withText(editedDescription)));
    }

}
