package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.testutils.CheckImageNewsIsDisplayed.checkChoseCategory;
import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.ControlPanel;
import ru.iteco.fmhandroid.ui.pageobjects.CreateNews;
import ru.iteco.fmhandroid.ui.pageobjects.EditNews;
import ru.iteco.fmhandroid.ui.pageobjects.FilterNews;
import ru.iteco.fmhandroid.ui.pageobjects.MainPage;
import ru.iteco.fmhandroid.ui.pageobjects.NewsPage;
import ru.iteco.fmhandroid.ui.testutils.TestBaseLogin;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTest extends TestBaseLogin {
    ActionBar actionBar = new ActionBar();
    FilterNews filterNews = new FilterNews();
    NewsPage newsPage = new NewsPage();
    ControlPanel controlPanel = new ControlPanel();
    MainPage mainPage = new MainPage();
    CreateNews createNews = new CreateNews();
    EditNews editNews = new EditNews();



    @Test
    public void newsPageTest(){

        actionBar.pressMenuButton();
        actionBar.pressMenuNews();
        newsPage.pressSortNews();
        newsPage.pressSortNews();
        newsPage.pressFilterNews();
        filterNews.pressDismiss();
        newsPage.pressEdit();
        controlPanel.getAddNewsButton().check(matches(isDisplayed()));
        Espresso.pressBack();
        newsPage.getNewsContainer().check(matches(isDisplayed()));
        newsPage.pressExpandNews(0);
        newsPage.pressDescription(0);
        newsPage.pressDescription(0);
        newsPage.pressExpandNews(0);
    }
    @Test
    public void createAndDeleteNewsTest(){
        String description = "Эта новость сделана автоматически, вскоре она будет удалена";
        int position = 0;
        mainPage.pressAllNews();
        newsPage.pressEdit();
        controlPanel.pressAddNews();
        createNews.pressNewsCategory();
        createNews.pressCategory(position);
        createNews.pressDate();
        createNews.pressOk();
        createNews.pressTime();
        createNews.pressOk();
        createNews.inputTextDescription(description);
        createNews.pressSave();

        actionBar.pressMenuButton();
        actionBar.pressMenuNews();
        newsPage.pressNewsItem(position);
        newsPage.getNewsItemDescription(position).check(matches(withText(description)));
        newsPage.pressEdit();
        newsPage.pressNewsItem(position);
        newsPage.getNewsItemDescription(position).check(matches(withText(description)));
        controlPanel.pressDeleteNews(position);
        createNews.pressOk();
        actionBar.pressMenuButton();
        actionBar.pressMenuMain();
        newsPage.getNewsItemDescription(position).check(matches(not(withText(description))));

    }
    @Test
    public void checkCategoryFilterNewsTest(){
        int categoryPos = 3;
        mainPage.pressAllNews();
        newsPage.pressFilterNews();

        filterNews.pressNewsCategory();
        filterNews.pressCategory(categoryPos);
        filterNews.pressDateStart();
        createNews.pressOk();
        filterNews.pressDateEnd();
        createNews.pressOk();
        filterNews.pressFilter();
        checkChoseCategory(categoryPos);
    }
    @Test
    public void editNewsTest(){
        int itemPos = 0;
        mainPage.pressAllNews();
        newsPage.pressEdit();
        controlPanel.pressEditNews(itemPos);
        String editedDescription = "Автоматически изменённое описание 1";
        editNews.pressDismiss();
        editNews.pressOk();
        controlPanel.pressEditNews(0);
        editNews.pressDismiss();
        editNews.pressCancel();
        editNews.inputTextDescription(editedDescription);
        editNews.pressSave();
        newsPage.getNewsItemDescription(itemPos).check(matches(withText(editedDescription)));
    }

}
