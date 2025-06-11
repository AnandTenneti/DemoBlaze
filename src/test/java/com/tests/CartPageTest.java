package com.tests;

import com.pages.CartPage;
import com.pages.HeaderPage;
import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest{

    @Test(priority = 1, dataProvider = "productName", dataProviderClass = DataSupplier.class,
            description = "Verify the product price in the cart matches the total price")
    public void test_PriceInCart(String productName) throws InterruptedException {
        int sumOfProductPrices = 0;

        System.out.println("Retrieving product details...");
        Thread.sleep(3000);

        // Click on a specific product
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAProduct(productName);
        Thread.sleep(3000);


        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickAddToCart();

        String alertText = productDetailsPage.getAlertMessageText();
        Assert.assertEquals(alertText, "Product added", "Alert text is not matching");
        productDetailsPage.acceptAlert();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCartLink();

        CartPage cartPage = new CartPage(driver);
        cartPage.waitForCartPageToLoad();
        Thread.sleep(3000);
        System.out.println("Retrieving the product price in the cart...");

        sumOfProductPrices = cartPage.getSumOfProductPrices();
        System.out.println("Product Price in Cart: " + sumOfProductPrices);
        String totalPrice = replaceNonNumeric(productDetailsPage.getTotalPrice());
        System.out.println("Total Price in Cart: " + (totalPrice));
        Assert.assertEquals
                (sumOfProductPrices, Integer.parseInt(totalPrice), "Product price in cart does " +
                        "not " +
                        "match total " +
                        "price");
        Thread.sleep(2000);
    }

}
