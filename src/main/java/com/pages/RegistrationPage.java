package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    SelfHealing selfHealing;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
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
        selfHealing = new SelfHealing();
        selfHealing.getSelfHealedLocator(driver, LocatorsRepository.getSignUserNames());
        userName.sendKeys(username);
    }

    public WebElement getUserNameField() {
        return userName;
    }

    public WebElement getField(int choice) {
        // Example choice, can be modified based on your logic
        switch (choice) {
            case 1:
                return userName;
            case 2:
                return password;
            default:
                throw new IllegalArgumentException("Invalid choice: " + choice);
        }
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

    public void waitUntilModalDialogIsDisplayed() {
        wait.until(driver -> signInModalLabel.isDisplayed());
    }

    public boolean isSignInModalDisplayed() {
        return signInModalLabel.isDisplayed();
    }
}
