package ru.iteco.fmhandroid.ui.testutils;



import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;

import org.junit.Test;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.LoginPage;

public class TestHelper extends Matchers {
    protected static String loginName = "login2";
    protected static String password = "password2";
    static void login(){

        LoginPage.inputLoginString(loginName);
        LoginPage.inputPasswordString(password);
        LoginPage.pressLoginButton();

    }
     static void logout(){
         ActionBar.pressProfileButton();
         ActionBar.pressLogoutButton();
    }
    @Step("Вход в аккаунт")
    public static void loginIfNeeded(){
        Allure.step("Вход в аккаунт");
        try {
            login();
        } catch (NoMatchingViewException ignored){
        }
    }
    @Step("Выход из аккаунта")
    public static void logoutIfNeeded(){
        Allure.step("Выход из аккаунта");
        try {
            logout();
        } catch (PerformException ignored){
        }
    }
}

