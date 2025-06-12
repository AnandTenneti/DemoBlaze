package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        PageFactory.initElements(driver, this);
    }

    // Add locators and methods for interacting with product details page elements here
    @FindBy(xpath = "//h2[@class='name']")
    private WebElement productName;

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id='more-information']/p")
    private WebElement productDescription;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(id = "totalp")
    private WebElement totalPrice;




    public void clickAddToCart() {
        addToCartButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertMessageText() {
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        return alertText;
    }

    public void acceptAlert() {
        alert.accept();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }


}
