package com.automationExcersise.pages;

import com.automationExcersise.utils.BrowserActions;
import com.automationExcersise.utils.CsvDataReader;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private BrowserActions browserActions;
    private CsvDataReader csvDataReader;

    public BasePage(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        csvDataReader = new CsvDataReader("src/main/resources/objects/xpaths.csv");
    }

    /**
     * Common method to accept cookies
     */
    public void acceptCookies() {
        String acceptCookiesButtonXpath = csvDataReader.getData("homePage.acceptCookies");
        browserActions.waitForElement(acceptCookiesButtonXpath);
        browserActions.clickElementByXPath(acceptCookiesButtonXpath);
    }
}
