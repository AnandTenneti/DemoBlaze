package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    static WebDriver driver;
    public static WebDriver initDriver() {
        System.out.println("Setting up the test environment...");
        WebDriverManager.chromedriver().setup();
        System.out.println("WebDriver setup complete.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
