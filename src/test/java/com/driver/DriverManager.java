package com.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverManager {
    static WebDriver driver;

    public static WebDriver initDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new org.openqa.selenium.firefox.FirefoxDriver();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments("--headless");

                break;
            // Add cases for other browsers if needed
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        System.out.println("Setting up the test environment...");

        System.out.println("WebDriver setup complete.");


        //options.addArguments("--headless");// Uncomment this line to run in headless mode


        return driver;
    }

}
