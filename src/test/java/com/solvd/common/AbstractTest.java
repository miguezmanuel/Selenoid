package com.solvd.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

public class AbstractTest {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.get("https://www.saucedemo.com/"); // ✅ URL corregida
        System.out.println("Page loaded: " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driverThreadLocal.get() != null) {
            try {
                File screenshot = ((TakesScreenshot) driverThreadLocal.get()).getScreenshotAs(OutputType.FILE);
                Files.copy(screenshot.toPath(), new File("screenshot.png").toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}





