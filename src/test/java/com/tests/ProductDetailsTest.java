package com.tests;

import com.pages.CartPage;
import com.pages.HeaderPage;
import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static com.driver.DriverManager.initDriver;

public class ProductDetailsTest extends BaseTest {

    @Test(priority = 1, dataProvider = "productDataProvider")
    public void getProductDetails(String productName) throws InterruptedException {
        System.out.println("Retrieving product details...");
        System.out.println("Title of the page is: " + driver.getTitle());

        // Navigate to the Laptops section

        Thread.sleep(2000);

        // Click on a specific product
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAProduct(productName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='name']")));
        // Retrieve and print product details
        String productName1 = driver.findElement(By.cssSelector("h2[class='name']")).getText();
        String productPrice = driver.findElement(By.cssSelector("h3[class='price-container']")).getText();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + replaceNonNumeric(productPrice));
        System.out.println("Product details retrieved successfully.");
        driver.findElement(By.linkText("Add to cart")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Product added", "Alert text is not matching");
        Thread.sleep(1000);
        alert.accept();
        driver.findElement(By.linkText("Cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));
    }

    @Test(priority = 2)
    public void getTotalPriceInCart() throws InterruptedException {
        String productName = "Sony vaio i5";
        System.out.println("Retrieving product details...");
        Thread.sleep(3000);

        // Click on a specific product
        // driver.findElement(By.linkText(productName)).click();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAProduct(productName);
        Thread.sleep(3000);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickAddToCart();

        String alertText = productDetailsPage.getAlertMessageText();
        Assert.assertEquals(alertText, "Product added", "Alert text is not matching");
        //Thread.sleep(3000);
        productDetailsPage.acceptAlert();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCartLink();

        CartPage cartPage = new CartPage(driver);
        cartPage.waitForCartPageToLoad();
        Thread.sleep(3000);
        System.out.println("Retrieving the product price in the cart...");
        String productPriceInCart = driver.findElement
                (By.xpath("//tbody[@id='tbodyid']/tr/td[3]")).getText();
        System.out.println("Product Price in Cart: " + replaceNonNumeric(productPriceInCart));
        String totalPrice = productDetailsPage.getTotalPrice();
        System.out.println("Total Price in Cart: " + replaceNonNumeric(totalPrice));
        Assert.assertEquals
                (productPriceInCart, totalPrice, "Product price in cart does not match total " +
                        "price");
        Thread.sleep(2000);
    }

    @Test(priority = 3, dependsOnMethods = {"getProductDetails"})
    public void test_deleteItemInCart() throws InterruptedException {
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(2000);
        CartPage cartPage = new CartPage(driver);
        int cartItemCount = cartPage.getItemCountInCart();
        System.out.println("Current item count in cart: " + cartItemCount);
        cartPage.waitForCartPageToLoad();
        System.out.println("Deleting item from cart...");
        Thread.sleep(4000);
        cartPage.clickOnDeleteButton(0);
        Thread.sleep(5000);
        int newCartItemCount = cartPage.getItemCountInCart();
        System.out.println("New item count in cart after deletion: " + newCartItemCount);
        Assert.assertEquals(newCartItemCount, cartItemCount - 1, "Item count in cart did not decrease after deletion");
    }


    @DataProvider(name = "productDataProvider")
    public String[] productData() {
        String[] productName = new String[3];
        productName[0] = "Sony vaio i7";
        productName[1] = "Nexus 6";
        productName[2] = "Nokia lumia 1520";
        return productName;
    }

}
