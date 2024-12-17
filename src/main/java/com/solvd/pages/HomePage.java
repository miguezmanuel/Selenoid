package com.solvd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver webDriver;

    @FindBy(css = "input[aria-label='search']")
    WebElement searchBox;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void searchProduct(String product) {
        searchBox.sendKeys(product + Keys.ENTER);
    }
}
