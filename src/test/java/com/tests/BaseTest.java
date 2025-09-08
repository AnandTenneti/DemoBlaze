package com.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.configuration.ConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reportutils.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.driver.DriverManager.initDriver;

public class BaseTest {
    protected ExtentReports extent;
    protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    static WebDriver driver;
    ConfigReader configReader;

    ObjectMapper objectMapper;


    String baseURL;


    @Parameters({"browserName"})
    @BeforeSuite(alwaysRun = true)
    public void setup(String browserName) throws FileNotFoundException {
        extent = ExtentManager.getInstance();
        driver = initDriver(browserName);

    }


    @BeforeClass(alwaysRun = true)
    public void setBaseURL() throws FileNotFoundException {
        configReader = new ConfigReader();
        System.out.println("Initializing ConfigReader...");
        System.out.println("Setting up the base URL...");
        baseURL = configReader.getProperty("baseURL");
        driver.get(baseURL);
    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        ExtentTest test = ExtentManager.getInstance().createTest(method.getName());
        extentTest.set(test);
    }

    public ExtentTest getTest() {
        return extentTest.get();
    }

    @AfterMethod(alwaysRun = true)
    public void updateTestStatus(ITestResult result) {
        String[] groups = result.getMethod().getGroups();
        for (String group : groups) {
            getTest().assignCategory(group);
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            getTest().fail("Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            getTest().pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            getTest().skip("Test Skipped");
        }
    }


//    @AfterTest
//    public void tearDown() {
//        System.out.println("Tearing down the test environment...");
//        // Add any cleanup code here if needed
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("Tearing down the test environment...");
        // Add any cleanup code here if needed
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Flushing the reports...");
        extent.flush();
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

    public void scrollToTop() {
        System.out.println("Scrolling to the bottom of the page...");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
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
