package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "prev2")
    private WebElement previousButton;

    @FindBy(id = "next2")
    private WebElement nextButton;

    @FindBy(css = "h4.card-title>a")
    private List<WebElement> productLink;

    public void clickOnAProduct(String productName) {
        System.out.println("Clicking on product: " + productName);
        for (WebElement product : productLink) {
            System.out.println("Checking product: " + product.getText());
            if (product.getText().equalsIgnoreCase(productName)) {
                System.out.println("Found product: " + product.getText());
                product.click();
                break;
            }
        }
        //driver.findElement(By.linkText(productName)).click();
    }

    public void clickOnACategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
    }

    public boolean isNextButtonDisplayed() {
        return nextButton.isDisplayed();
    }


}
