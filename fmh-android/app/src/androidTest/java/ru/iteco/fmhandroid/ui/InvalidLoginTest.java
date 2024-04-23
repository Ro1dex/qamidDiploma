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

    @Test

    public void invalidLoginTest(){
        LoginPage.inputLoginString("login");
        LoginPage.inputPasswordString("password2");
        LoginPage.pressLoginButton();
        checkToastMessage("Неверный логин или пароль");
    }
    @Test
    public void invalidPasswordTest(){
        LoginPage.inputLoginString("login2");
        LoginPage.inputPasswordString("password");
        LoginPage.pressLoginButton();
        checkToastMessage("Неверный логин или пароль");
    }
    @Test
    public void emptyLoginAndPasswordTest(){
        LoginPage.pressLoginButton();
        checkToastMessage("Логин и пароль не могут быть пустыми");
    }

}

