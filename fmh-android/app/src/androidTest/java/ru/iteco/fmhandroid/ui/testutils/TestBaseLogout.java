package ru.iteco.fmhandroid.ui.testutils;

import org.junit.Before;

public class TestBaseLogout extends Matchers {
    TestHelper testHelper = new TestHelper();
    @Before
    public void logout(){
        testHelper.logoutIfNeeded();
    }
}
