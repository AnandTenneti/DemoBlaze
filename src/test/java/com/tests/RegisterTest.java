package com.tests;

import com.pages.HeaderPage;
import com.pages.RegistrationPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerClass.class)
public class RegisterTest extends BaseTest {

    @Test(priority=1)
    public void testRegister() throws InterruptedException {
        System.out.println("Title of the page is: " + driver.getTitle());
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnSignUpLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitUntilModalDialogIsDisplayed();
        Assert.assertEquals(registrationPage.isSignInModalDisplayed(), true,
                "Sign up modal is not displayed");
        registrationPage.enterUserName("testuser");
        highlight(driver, registrationPage.getField(2));
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void testLoginWithInvalidCredentials() throws InterruptedException {
        System.out.println("Title of the page is: " + driver.getTitle());
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnSignUpLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitUntilModalDialogIsDisplayed();
        Assert.assertEquals(registrationPage.isSignInModalDisplayed(), true,
                "Sign in modal is not displayed");
        registrationPage.clickOnSignUpButton();
        String alertMessageText = registrationPage.getAlertMessageText();
        Assert.assertEquals(alertMessageText, "Please fill out Username and Password.",
                "Alert text is not matching");
        Thread.sleep(5000);
        registrationPage.acceptAlert();
        Thread.sleep(3000);
    }


    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
