package com.solvd;

import com.solvd.pages.HomePage;
import com.solvd.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest {

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @BeforeTest
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/manumiguez/Documents/chrome-mac/Chromium.app/Contents/MacOS/Chromium");
        System.setProperty("webdriver.chrome.driver", "/Users/manumiguez/Documents/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bookcart.azurewebsites.net/");
    }

    @Test
    public void testSearchFunctionality() {
        homePage = new HomePage(driver);
        homePage.searchProduct("Laptop");

        searchResultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(searchResultsPage.isResultListNotEmpty());
        searchResultsPage.printAllTitles();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
