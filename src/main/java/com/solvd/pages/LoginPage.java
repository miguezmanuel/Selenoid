package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(id = "user-name")
    WebElement usernameField;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    public boolean isUsernameVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameField));
            return usernameField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}