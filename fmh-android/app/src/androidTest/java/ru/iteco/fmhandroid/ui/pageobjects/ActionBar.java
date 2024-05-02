package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.Matchers;

public class ActionBar extends Matchers {

    ViewInteraction imageTradeMark = onView(withId(R.id.trademark_image_view));
    public ViewInteraction getImageTradeMark(){
        return imageTradeMark;
    }
    ViewInteraction profileButton = onView(allOf(withId(R.id.authorization_image_button)));

    @Step("Нажатие кнопки профиля")
    public void pressProfileButton() {
        Allure.step("Нажатие кнопки профиля");
        profileButton.perform(click());
    }

    DataInteraction logoutButton = onData(anything())
            .inRoot(isPlatformPopup())
            .atPosition(0);

    @Step("Нажатие выйти из профиля")
    public void pressLogoutButton() {
        Allure.step("Нажатие выйти из профиля");
        logoutButton.perform(click());
    }

    ViewInteraction menuButton = onView(
            allOf(withId(R.id.main_menu_image_button)));

    @Step("Нажатие кнопки Меню")
    public void pressMenuButton() {
        Allure.step("Нажатие кнопки Меню");
        menuButton.perform(click());
    }

    DataInteraction menuAbout = onData(anything())
            .inRoot(isPlatformPopup())
            .atPosition(2);

    @Step("Выбор из списка 'о приложении'")
    public void pressMenuAbout() {
        Allure.step("Выбор из списка 'о приложении'");
        menuAbout.perform(click());
    }

    DataInteraction menuNews = onData(anything())
            .inRoot(isPlatformPopup())
            .atPosition(1);

    @Step("Выбор из списка 'Новости'")
    public void pressMenuNews() {
        Allure.step("Выбор из списка 'Новости'");
        menuNews.perform(click());
    }

    DataInteraction menuMain = onData(anything())
            .inRoot(isPlatformPopup())
            .atPosition(0);

    @Step("Выбор из списка 'Главная'")
    public void pressMenuMain() {
        Allure.step("Выбор из списка 'Главная'");
        menuMain.perform(click());
    }

    ViewInteraction ourMissionButton = onView(
            allOf(withId(R.id.our_mission_image_button)));

    @Step("Нажатие на кнопку 'Наша Миссия'")
    public void pressOurMissionButton() {
        Allure.step("Нажатие на кнопку 'Наша Миссия'");
        ourMissionButton.perform(click());
    }


}
