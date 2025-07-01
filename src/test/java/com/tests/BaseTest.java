package com.tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import static com.driver.DriverManager.initDriver;

public class BaseTest {
   static  WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = initDriver();
    }

    @BeforeMethod
    public void setBaseURL() {
        System.out.println("Setting up the base URL...");
        driver.get("https://www.demoblaze.com/");
    }


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
    public void captureScreenshot(String fileName) throws IOException {
        System.out.println("Capturing screenshot for test: " + fileName);
        // Implement screenshot capture logic here
        // Example: Use a library like AShot or Selenium's TakesScreenshot to capture the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Save the screenshot to a desired location
         FileUtils.copyFile(srcFile, new File("screenshots/" + fileName + ".png"));
        System.out.println("Screenshot saved as: " + fileName + ".png");
    }
}
