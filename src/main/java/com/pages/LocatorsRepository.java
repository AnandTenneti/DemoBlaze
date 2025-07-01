package com.pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class LocatorsRepository {

    public static List<By> getUserNames() {
        List<By> userNames = new ArrayList<>();
        userNames.add(By.id("loginusername"));
        userNames.add(By.cssSelector("#loginusername"));
        userNames.add(By.xpath("//input[@id='loginusername']"));
        return userNames;
    }

    public static List<By> getPassword() {
        List<By> password = new ArrayList<>();
        password.add(By.id("loginpassword"));
        password.add(By.cssSelector("#loginpassword"));
        password.add(By.xpath("//input[@id='loginpassword']"));
        return password;
    }
    public static List<By> getLoginButton() {
        List<By> loginButton = new ArrayList<>();
        loginButton.add(By.xpath("//button[text()='Log in']"));
        loginButton.add(By.cssSelector("button[type='submit']"));
        return loginButton;
    }
    public static List<By> getSignUserNames() {
        List<By> userNames = new ArrayList<>();
        userNames.add(By.id("sign-username1"));
        userNames.add(By.cssSelector("#signusername"));
        userNames.add(By.xpath("((//label[text()='Username:']/following-sibling::input)[1]"));
        return userNames;
    }
}

