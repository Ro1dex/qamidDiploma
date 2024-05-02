package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testutils.Matchers;

public class LoginPage extends Matchers {
    ViewInteraction textInputLogin = onView(allOf(childAtPosition(childAtPosition(withId(R.id.login_text_input_layout), 0), 1)));

    @Step("Вставка логина")
    public void inputLoginString(String login) {
        Allure.step("Вставка логина");
        textInputLogin.perform(replaceText(login), closeSoftKeyboard());
    }

    ViewInteraction textInputPassword = onView(allOf(childAtPosition(childAtPosition(withId(R.id.password_text_input_layout), 0), 1)));

    @Step("Вставка пароля")
    public void inputPasswordString(String password) {
        Allure.step("Вставка пароля");
        textInputPassword.perform(replaceText(password), closeSoftKeyboard());
    }

    ViewInteraction loginButton = onView(withId(R.id.enter_button));
    public ViewInteraction getLoginButton(){
        return loginButton;
    }

    @Step("Нажатие кнопки логина")
    public void pressLoginButton() {
        Allure.step("Нажатие кнопки логина");
        loginButton.perform(click());
    }
}
