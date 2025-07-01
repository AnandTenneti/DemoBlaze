package com.tests;

import com.pages.HeaderPage;
import com.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test
    public void test_LoginPage() throws InterruptedException {
        HeaderPage headerPage = new HeaderPage(driver);
        System.out.println("Navigating to Login Page...");
        headerPage.clickOnLogInLink();
        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("Entering username and password...");
        loginPage.enterUserName("test@testone.com");
        loginPage.enterPassword("test123");
        System.out.println("Clicking on Login button...");
        loginPage.clickOnLoginButton();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(8000);
        System.out.println("Verifying the page title...");
        headerPage.clickOnLogOutLink();
        Thread.sleep(5000);

    }
}
