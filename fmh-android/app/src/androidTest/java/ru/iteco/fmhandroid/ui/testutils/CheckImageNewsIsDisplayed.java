package ru.iteco.fmhandroid.ui.testutils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.fail;

import android.util.Log;

import androidx.test.espresso.AmbiguousViewMatcherException;
import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class CheckImageNewsIsDisplayed extends Matchers {
    public static void checkChoseCategory(int pos) {
        switch (pos) {
            case 0:
                updateDrawableVisibility(R.raw.icon_advertisement, true);
                break;
            case 1:
                updateDrawableVisibility(R.raw.icon_birthday, true);
                break;
            case 2:
                updateDrawableVisibility(R.raw.icon_salary, true);
                break;
            case 3:
                updateDrawableVisibility(R.raw.icon_union, true);
                break;
            case 4:
                updateDrawableVisibility(R.raw.icon_holiday, true);
                break;
            case 5:
                updateDrawableVisibility(R.raw.icon_massage, true);
                break;
            case 6:
                updateDrawableVisibility(R.raw.icon_gratitude, true);
                break;
            case 7:
                updateDrawableVisibility(R.raw.icon_help, true);
                break;
            default:
                break;
        }
    }

    @Step("Проверка соответствия изображений значка новостей выбранной категории")
    private static void updateDrawableVisibility(int drawableId, boolean isVisible) {
        Allure.step("Проверка соответствия изображений значка новостей выбранной категории");
        try {
            onView(allOf(withId(R.id.category_icon_image_view), withDrawable(drawableId))).check(matches(isVisible ? isDisplayed() : not(isDisplayed())));
        } catch (NoMatchingViewException e) {
            fail("Изображение с идентификатором " + drawableId + " не было найдено на экране. Попробуйте другую категорию");
        } catch (AmbiguousViewMatcherException e) {
            Log.e("Image Visibility Check", "Найдено несколько объектов, соответствующих критериям поиска.");
        }

    }
}
