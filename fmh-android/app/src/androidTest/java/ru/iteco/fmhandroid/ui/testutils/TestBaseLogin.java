package ru.iteco.fmhandroid.ui.testutils;

import org.junit.After;
import org.junit.Before;

public class TestBaseLogin extends Matchers {
    TestHelper testHelper =new TestHelper();
    @Before
    public void login(){
        testHelper.loginIfNeeded();
    }
    @After
    public void logout(){
        testHelper.logoutIfNeeded();
    }
}
