package com.automationExcersise.test;

import com.automationExcersise.pages.BasePage;
import com.automationExcersise.pages.HomePage;
import com.automationExcersise.pages.LoginPage;
import com.automationExcersise.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import jdk.jfr.Description;

public class HomePageTest {

    private WebDriver driver;
    private BrowserActions browserActions;
    private BasePage basePage;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeTest
    public void setup() {
        driver = browserActions.setupDriver();
        browserActions = new BrowserActions(driver);
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Description("TC-001")
    public void homePage() {
        driver.get("https://automationexercise.com/");
        basePage.acceptCookies();
    }
}