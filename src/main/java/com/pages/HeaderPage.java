package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement contactLink;

    @FindBy(xpath = "//a[text()='About us']")
    private WebElement aboutUsLink;

    //    @FindBy(xpath = "//a[text()='Cart']")
//    private WebElement cartLink;
    @FindBy(linkText = "Cart")
    private WebElement cartLink;

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement logInLink;

    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement signUpLink;

    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement logOutLink;

    public void clickOnContactLink() {
        contactLink.click();
    }

    public void clickOnAboutUsLink() {
        aboutUsLink.click();
    }

    public void clickOnCartLink() {
        cartLink.click();
    }

    public void clickOnLogInLink() {
        logInLink.click();
    }

    public void clickOnLogOutLink() {
        logOutLink.click();
    }

    public void clickOnSignUpLink() {
        signUpLink.click();
    }
}
