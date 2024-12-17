package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    WebDriver webDriver;

    @FindBy(css = "div[role='listbox']")  // CSS selector para títulos de resultados
    private List<WebElement> resultTitles;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isResultListNotEmpty() {
        return !resultTitles.isEmpty();
    }

    public void printAllTitles() {
        resultTitles.forEach(title -> System.out.println(title.getText()));
    }
}
