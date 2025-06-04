package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = initDriver();
    }

    @BeforeMethod
    public void setBaseURL() {
        System.out.println("Setting up the base URL...");
        driver.get("https://www.demoblaze.com/");
    }


    @Test
    public void addProductToCart() throws InterruptedException {
        System.out.println("Adding product to cart...");
        // Add your test code here
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Sony vaio i7")).click();
        //String headerText = driver.findElement(By.cssSelector("h2[class='name']")).getText();
        // Assert.assertEquals(headerText, "Sony vaio i7",
        //       "Product header text does not match");
        Assert.assertEquals(driver.findElement(By.linkText("Add to cart")).isDisplayed(), true,
                "Add to cart button is not displayed");
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Product added", "Alert text is not matching");
        Thread.sleep(4000);
        alert.accept();
    }

    @Test(priority = 3)
    public void scrollToBottom() throws InterruptedException {
        System.out.println("Scrolling to the bottom of the page...");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("next2")).isDisplayed(),
                "Next button is not displayed at the bottom of the page");
    }

    @Test(priority = 4)
    public void scrollToElementView() throws InterruptedException {
        System.out.println("Scrolling to element view...");
        Thread.sleep(3000);
        WebElement productLink = driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", productLink);
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
//        Assert.assertEquals(driver.getTitle(), "Sony vaio i5", "Product page title does not match");
        Thread.sleep(3000);
    }

}
