package ru.iteco.fmhandroid.ui.testutils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.testutils.TestBase;
import ru.iteco.fmhandroid.ui.testutils.ToastMatcher;

public class CheckToastMessage extends TestBase {

    public static void checkToastMessage (String toast){
        Allure.step("Проверка toast-сообщения");
        onView(withText(toast)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }
}
