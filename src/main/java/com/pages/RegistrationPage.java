package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    Alert alert;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sign-username")
    private WebElement userName;

    @FindBy(id = "sign-password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    private WebElement signUpButton;

    @FindBy(css = "button[text()='Close']")
    private WebElement closeButton;

    @FindBy(id = "signInModalLabel")
    private WebElement signInModalLabel;

public void clickOnSignUpButton() {
        signUpButton.click();
    }

    public void enterUserName(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
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

    public void clickOnCloseButton() {
        closeButton.click();
    }

    public String getSignInModalLabelText() {
        return signInModalLabel.getText();
    }
}
