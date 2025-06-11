package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.driver.DriverManager.initDriver;

public class BaseTest {
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

//    public WebDriver initDriver() {
//        System.out.println("Setting up the test environment...");
//        WebDriverManager.chromedriver().setup();
//        System.out.println("WebDriver setup complete.");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        return driver;
//    }

    @AfterTest
    public void tearDown() {
        System.out.println("Tearing down the test environment...");
        // Add any cleanup code here if needed
        if (driver != null) {
            driver.quit();
        }
    }

    public String replaceNonNumeric(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("[^0-9]", "");
    }

    public void scrollToBottom() {
        System.out.println("Scrolling to the bottom of the page...");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollElementIntoView(WebElement elementId) {
        System.out.println("Scrolling to the element with ID: " + elementId);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", elementId);
    }
}
