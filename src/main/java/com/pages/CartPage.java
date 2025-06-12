package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "totalp")
    private WebElement totalPrice;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[3]")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[4]/a")
    private List<WebElement> deleteButtons;


    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void waitForCartPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
    }

    public void clickOnDeleteButton(int index) {
        if (deleteButtons.size() == 1) {
            deleteButtons.get(0).click();
        }
        if (deleteButtons.size() > 1 && index < deleteButtons.size()) {
            deleteButtons.get(index).click();
        }
    }

    public int getItemCountInCart() {
        return cartItems.size();
    }

    public int getSumOfProductPrices() {
        int sum = 0;
        for (WebElement priceElement : productPrice) {
            sum += Integer.parseInt(priceElement.getText()); // Remove non-numeric characters
        }
        return sum;
    }

    public void clickOnPlaceOrderButton() {
        placeOrderButton.click();
    }

}
