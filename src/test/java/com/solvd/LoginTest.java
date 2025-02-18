package com.solvd;

import com.solvd.common.AbstractTest;
import com.solvd.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    @Test
    public void testUsernameFieldIsVisible() {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUsernameVisible(), "Userfield is not visible");
    }

}
