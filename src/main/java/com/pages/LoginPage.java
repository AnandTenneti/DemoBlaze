package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class LoginPage {
    SelfHealing selfHealing;
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "loginusername")
    private WebElement loginUsername;

    @FindBy(id = "loginpassword")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;



    public void enterUserName(String username) {

        selfHealing.getSelfHealedLocator(driver, LocatorsRepository.getUserNames());
        loginUsername.sendKeys(username);
    }

    public void enterPassword(String password) {

        selfHealing.getSelfHealedLocator(driver, LocatorsRepository.getPassword());
        loginPassword.sendKeys(password);
    }

    public void clickOnLoginButton() {
        selfHealing.getSelfHealedLocator(driver, LocatorsRepository.getLoginButton());
        loginButton.click();
    }



    }



