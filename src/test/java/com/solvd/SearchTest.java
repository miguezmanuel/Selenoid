package com.solvd;

import com.solvd.common.BaseTest;
import com.solvd.pages.HomePage;
import com.solvd.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Harry Potter");

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(searchResultsPage.isResultListNotEmpty(), "The search results list is empty. No products were found :(");
    }

}
