package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderPage {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;
    @FindBy(id = "orderModalLabel")
    private WebElement modalDialog;



    public void clickOnPurchaseButton() {
        purchaseButton.click();
    }

    public boolean isModalDialogDisplayed() {
        return modalDialog.isDisplayed();
    }
    public void waitUntilAlertIsDisplayed() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> {
            try {
                alert = driver.switchTo().alert();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public String getAlertMessageText() {
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }

    public void acceptAlert() {
        if (alert != null) {
            alert.accept();
        }
    }

}
