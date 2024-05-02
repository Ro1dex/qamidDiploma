package ru.iteco.fmhandroid.ui;


import static ru.iteco.fmhandroid.ui.testutils.CheckToastMessage.checkToastMessage;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.pageobjects.LoginPage;
import ru.iteco.fmhandroid.ui.testutils.TestBaseLogout;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class InvalidLoginTest extends TestBaseLogout {
    private final LoginPage loginPage = new LoginPage();

    @Test

    public void invalidLoginTest(){
        loginPage.inputLoginString("login");
        loginPage.inputPasswordString("password2");
        loginPage.pressLoginButton();
        checkToastMessage("Неверный логин или пароль");
    }
    @Test
    public void invalidPasswordTest(){
        loginPage.inputLoginString("login2");
        loginPage.inputPasswordString("password");
        loginPage.pressLoginButton();
        checkToastMessage("Неверный логин или пароль");
    }
    @Test
    public void emptyLoginAndPasswordTest(){
        loginPage.pressLoginButton();
        checkToastMessage("Логин и пароль не могут быть пустыми");
    }

}

