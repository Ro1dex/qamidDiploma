package ru.iteco.fmhandroid.ui.testutils;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import ru.iteco.fmhandroid.R;

public class CheckImageNewsIsDisplayed extends TestBase{
    public static void chosePosition(int pos){

        if(pos == 0){withDrawable(R.raw.icon_advertisement).matches(isDisplayed());}
        else if(pos !=0){withDrawable(R.raw.icon_advertisement).matches(not(isDisplayed()));}
        else if(pos == 1){withDrawable(R.raw.icon_birthday).matches(isDisplayed());}
        else if(pos != 1){withDrawable(R.raw.icon_birthday).matches(not(isDisplayed()));}
        else if(pos == 2){withDrawable(R.raw.icon_salary).matches(isDisplayed());}
        else if(pos!=2){withDrawable(R.raw.icon_salary).matches(not(isDisplayed()));}
        else if(pos == 3){withDrawable(R.raw.icon_union).matches(isDisplayed());}
        else if(pos !=3){ withDrawable(R.raw.icon_union).matches(not(isDisplayed()));}
        else if(pos == 4){withDrawable(R.raw.icon_holiday).matches(isDisplayed());}
        else if(pos !=4){withDrawable(R.raw.icon_holiday).matches(not(isDisplayed()));}
        else if(pos == 5){withDrawable(R.raw.icon_massage).matches(isDisplayed());}
        else if(pos != 5){withDrawable(R.raw.icon_massage).matches(not(isDisplayed()));}
        else if(pos == 6){withDrawable(R.raw.icon_gratitude).matches(isDisplayed());}
        else if(pos != 6){withDrawable(R.raw.icon_gratitude).matches(not(isDisplayed()));}
        else if(pos == 7){withDrawable(R.raw.icon_help).matches(isDisplayed());}
        else if(pos !=7){withDrawable(R.raw.icon_help).matches(not(isDisplayed()));}
    }
}
