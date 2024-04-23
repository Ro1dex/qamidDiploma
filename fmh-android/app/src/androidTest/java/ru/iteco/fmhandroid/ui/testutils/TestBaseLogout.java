package ru.iteco.fmhandroid.ui.testutils;

import org.junit.Before;

import ru.iteco.fmhandroid.ui.testutils.TestBase;
import ru.iteco.fmhandroid.ui.testutils.TestHelper;

public class TestBaseLogout extends TestBase {
    @Before
    public void logout(){
        TestHelper.logoutIfNeeded();
    }
}
