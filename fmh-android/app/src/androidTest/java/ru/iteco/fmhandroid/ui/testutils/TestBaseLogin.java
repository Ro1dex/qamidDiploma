package ru.iteco.fmhandroid.ui.testutils;

import org.junit.After;
import org.junit.Before;

public class TestBaseLogin extends TestBase {
    @Before
    public void login(){
        TestHelper.loginIfNeeded();
    }
    @After
    public void logout(){
        TestHelper.logoutIfNeeded();
    }
}
