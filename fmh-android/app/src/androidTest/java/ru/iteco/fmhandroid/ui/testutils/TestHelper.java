package ru.iteco.fmhandroid.ui.testutils;



import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;

import org.junit.Test;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.DataAuth;
import ru.iteco.fmhandroid.ui.pageobjects.LoginPage;

public class TestHelper extends Matchers {
    LoginPage loginPage = new LoginPage();
    ActionBar actionBar = new ActionBar();
    DataAuth dataAuth =new DataAuth();
    void login(){

        loginPage.inputLoginString(dataAuth.getLogin());
        loginPage.inputPasswordString(dataAuth.getPassword());
        loginPage.pressLoginButton();

    }
     void logout(){
         actionBar.pressProfileButton();
         actionBar.pressLogoutButton();
    }
    @Step("Вход в аккаунт")
    public void loginIfNeeded(){
        Allure.step("Вход в аккаунт");
        try {
            login();
        } catch (NoMatchingViewException ignored){
        }
    }
    @Step("Выход из аккаунта")
    public void logoutIfNeeded(){
        Allure.step("Выход из аккаунта");
        try {
            logout();
        } catch (PerformException ignored){
        }
    }
}

