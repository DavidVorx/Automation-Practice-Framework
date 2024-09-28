package com.automationExcersise.pages;

import com.automationExcersise.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import com.automationExcersise.utils.CsvDataReader;

public class HomePage extends BasePage {

    private BrowserActions browserActions;
    private CsvDataReader csvDataReader;

    public HomePage(WebDriver driver) {
        super(driver);
        browserActions = new BrowserActions(driver);
        csvDataReader = new CsvDataReader("src/main/resources/objects/xpaths.csv");
    }

    /**
     * Method to click on the Singup/Login button
     */
    public void clickSingupLoginButton(){
        String singupLoginButtonXpath = csvDataReader.getData("homePage.singupLoginButton");
        browserActions.waitForElement(singupLoginButtonXpath);
        browserActions.clickElementByXPath(singupLoginButtonXpath);
    }

}
