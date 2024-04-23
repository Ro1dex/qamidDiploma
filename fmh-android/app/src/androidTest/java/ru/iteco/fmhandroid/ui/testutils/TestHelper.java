package ru.iteco.fmhandroid.ui.testutils;



import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;

import ru.iteco.fmhandroid.ui.pageobjects.ActionBar;
import ru.iteco.fmhandroid.ui.pageobjects.LoginPage;

public class TestHelper extends TestBase {
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
    public static void loginIfNeeded(){
        try {
            login();
        } catch (NoMatchingViewException ignored){
        }
    }
    public static void logoutIfNeeded(){
        try {
            logout();
        } catch (PerformException ignored){
        }
    }
}

