package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelfHealing {

    public static WebElement getSelfHealedLocator(WebDriver driver, List<By> locatorStrategies) {
        WebElement element = null;
        for (By locator : locatorStrategies) {
            try {
                // Attempt to find the element using the current locator strategy
                element = driver.findElement(locator);
                System.out.println("Element found using locator: " + locator);
                break;
            } catch (Exception e) {
                // If the element is not found, continue to the next locator strategy
                System.out.println("Locator failed: " + locator + ". Trying next one...");
            }

        }
        return element;
    }
}

