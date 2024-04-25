package ru.iteco.fmhandroid.ui.testutils;

import org.junit.Before;

public class TestBaseLogout extends Matchers {
    @Before
    public void logout(){
        TestHelper.logoutIfNeeded();
    }
}
