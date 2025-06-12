package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up the test environment...");
        WebDriverManager.chromedriver().setup();
        System.out.println("WebDriver setup complete.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegister() throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.findElement(By.linkText("Sign up")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModalLabel")));
        Assert.assertEquals(driver.findElement(
                        By.id("signInModalLabel")).isDisplayed(), true,
                "Sign up modal is not displayed");
        WebElement usernameField = driver.findElement(By.id("sign-username"));
        highlight(driver, usernameField);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tearing down the test environment...");
        driver.quit();
    }
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }


//    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.demoblaze.com/");
//        System.out.println("Title of the page is: " + driver.getTitle());
//        driver.findElement(By.linkText("Sign up")).click();
//        Assert.assertEquals(driver.findElement(
//                        By.id("signInModalLabel")).isDisplayed(), true,
//                "Sign up modal is not displayed");
//        driver.quit();
//    }
}
