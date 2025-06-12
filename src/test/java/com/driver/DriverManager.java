package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    static WebDriver driver;

    public static WebDriver initDriver() {
        System.out.println("Setting up the test environment...");
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        System.out.println("WebDriver setup complete.");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");// Uncomment this line to run in headless mode
        driver = new ChromeDriver(options);


        return driver;
    }

}
