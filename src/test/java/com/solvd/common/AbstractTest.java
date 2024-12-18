package com.solvd.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {

//  varable for thread local ,,,
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/path/to/Chromium.app/Contents/MacOS/Chromium");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
