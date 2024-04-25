package ru.iteco.fmhandroid.ui.testutils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.fail;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;

public class CheckToastMessage extends Matchers {

    @Step("Проверка toast-сообщения")
    public static void checkToastMessage (String toast){
        Allure.step("Проверка toast-сообщения");
        try {
            onView(withText(toast)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {fail("Toast-сообщение: '" + toast + "' не найдено");}
    }
}
