package com.tests;

import com.pages.ContactUsPage;
import com.pages.HeaderPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {

    @Test
    public void test_sendMessage() throws InterruptedException {
        HeaderPage headerPage = new HeaderPage(driver);
        System.out.println("Navigating to Contact Us Page...");
        headerPage.clickOnContactLink();
        System.out.println("Entering message details...");

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Thread.sleep(5000);
        Assert.assertTrue(contactUsPage.isContactUsModalDisplayed(), "Contact Us page is not displayed");
        contactUsPage.clickOnSendMessageButton();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);


    }
}
