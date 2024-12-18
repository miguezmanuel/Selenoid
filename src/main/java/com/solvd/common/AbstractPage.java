package com.solvd.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(WebElement element) {
        logger.info("Clicking on element: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        logger.info("Sending keys to element: " + element + " with text: " + text);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        logger.info("Getting text from element: " + element);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
