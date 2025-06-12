package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "exampleModalLabel")
    private WebElement contactUsModal;

    @FindBy(id = "recipient-email")
    private WebElement contactEmail;

    @FindBy(id = "recipient-name")
    private WebElement contactName;

    @FindBy(id = "message-text")
    private WebElement subject;

    @FindBy(xpath = "//button[text()='Send message']")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeButton;

    public void clickOnSendMessageButton() {
        sendMessageButton.click();
    }

    public boolean isContactUsModalDisplayed() {
        return contactUsModal.isDisplayed();
    }


}
