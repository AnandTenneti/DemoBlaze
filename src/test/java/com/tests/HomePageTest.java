package com.tests;

import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "CPnames", dataProviderClass = DataSupplier.class,
            description = "Add a product to the cart from a specific category")
    public void addProductToCart(String categoryName, String productName) throws InterruptedException {
        System.out.println("Adding product to cart...");

        HomePage homePage = new HomePage(driver);
        homePage.clickOnACategory(categoryName);
        Thread.sleep(2000);
        homePage.clickOnAProduct(productName);
        Thread.sleep(2000);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickAddToCart();

        String alertText = productDetailsPage.getAlertMessageText();
        Assert.assertEquals(alertText, "Product added", "Alert text is not matching");
        Thread.sleep(3000);
        productDetailsPage.acceptAlert();
    }

    @Test(priority = 2)
    public void test_scrollToBottom() throws InterruptedException {
        System.out.println("Scrolling to the bottom of the page...");
        scrollToBottom();
        Thread.sleep(2000);
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isNextButtonDisplayed(),
                "Next button is not displayed at the bottom of the page");
    }

    @Test(priority = 3, dataProvider = "productName", dataProviderClass = DataSupplier.class,
            description = "Scroll to the product element and click on it")
    public void scrollToElementView(String productName) throws InterruptedException {
        System.out.println("Scrolling to element view...");
        Thread.sleep(3000);
        WebElement productLink =
                driver.findElement(By.xpath("//a[text()='" + productName + "']"));
        scrollElementIntoView(productLink);
        Thread.sleep(3000);
        Assert.assertTrue(productLink.isDisplayed(), "Product link is not displayed in view");
        productLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.price" +
                "-container")));

        String priceOfProduct = replaceNonNumeric(driver.findElement(
                By.cssSelector("h3.price-container")).getText());
        int productPrice =
                Integer.parseInt(priceOfProduct);
        System.out.println("The price of the product is " + productPrice);
        Thread.sleep(3000);
    }



}
