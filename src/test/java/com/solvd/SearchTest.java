package com.solvd;

import com.solvd.common.AbstractTest;
import com.solvd.pages.HomePage;
import com.solvd.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends AbstractTest {

    @Test
    public void testSearchFunctionality() {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct("Laptop");

        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        Assert.assertTrue(searchResultsPage.isResultListNotEmpty(), "The search results list is empty. No products were found.");
    }

}
