package com.tests;

import com.pages.CartPage;
import com.pages.HeaderPage;
import com.pages.PlaceOrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {
    @Test
    public void test_PlaceOrder() throws InterruptedException {
        // Navigate to the cart page
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCartLink();
        Thread.sleep(3000);

        // Proceed to checkout
        CartPage cartPage = new CartPage(driver);


        // Place the order
        cartPage.clickOnPlaceOrderButton();
        Thread.sleep(5000);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        Assert.assertTrue(placeOrderPage.isModalDialogDisplayed(),
                "Order modal is not displayed");
        Thread.sleep(5000);
        scrollToBottom();
        placeOrderPage.clickOnPurchaseButton();
        placeOrderPage.waitUntilAlertIsDisplayed();
        String alertText = placeOrderPage.getAlertMessageText();
        System.out.println("Alert text: " + alertText);
        Assert.assertEquals(alertText, "Please fill out Name and Creditcard.", "Alert text is not " +
                "matching");
        placeOrderPage.acceptAlert();
        Thread.sleep(5000);
    }
    @Test(priority=2, enabled=false)
    public void test_PlaceOrder_1() throws InterruptedException {
        // Navigate to the cart page
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCartLink();
        Thread.sleep(3000);

        // Proceed to checkout
        CartPage cartPage = new CartPage(driver);


        // Place the order
        cartPage.clickOnPlaceOrderButton();
        Thread.sleep(5000);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        Assert.assertTrue(placeOrderPage.isModalDialogDisplayed(),
                "Order modal is not displayed");
        Thread.sleep(5000);
        scrollToBottom();
        placeOrderPage.clickOnPurchaseButton();
        placeOrderPage.waitUntilAlertIsDisplayed();
        String alertText = placeOrderPage.getAlertMessageText();
        System.out.println("Alert text: " + alertText);
        Assert.assertEquals(alertText, "Please fill out Name and Creditcard.", "Alert text is not " +
                "matching");
        placeOrderPage.acceptAlert();
        Thread.sleep(5000);
    }
}
