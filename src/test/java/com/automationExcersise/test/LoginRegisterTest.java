package com.automationExcersise.test;

import com.automationExcersise.pages.BasePage;
import com.automationExcersise.pages.HomePage;
import com.automationExcersise.pages.LoginPage;
import com.automationExcersise.utils.BrowserActions;
import com.automationExcersise.utils.JsonDataReader;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import com.automationExcersise.pages.HomePage;
import com.automationExcersise.pages.LoginPage;
import com.automationExcersise.pages.BasePage;

public class LoginRegisterTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private BrowserActions browserActions;
    private JsonDataReader reader;
    private BasePage basePage; // Declare basePage
    private HomePage homePage;

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
    @Description("TC-002_Register User")
    public void register() {
        //Data
        reader = new JsonDataReader("TC-002");
        String url = reader.getData("url");
        String userName = reader.getData("userName");
        String email = reader.getData("email");
        String password = reader.getData("password");
        String day = reader.getData("day");
        String month = reader.getData("month");
        String year = reader.getData("year");
        String firtsName = reader.getData("firstName");
        String lastName = reader.getData("lastName");
        String company = reader.getData("company");
        String address = reader.getData("address");
        String address2 = reader.getData("address2");
        String country = reader.getData("country");
        String state = reader.getData("state");
        String city = reader.getData("city");
        String zipCode = reader.getData("zipcode");
        String mobilePhone = reader.getData("mobileNumber");

        //Test
        browserActions.goTo(url);
        basePage.acceptCookies();
        homePage.clickSingupLoginButton();
        loginPage.enterUsername(userName);
        loginPage.enterEmail(email);
        loginPage.clickSingupButton();
        loginPage.isEnterAccountVisible();
        loginPage.clickGenderMale();
        loginPage.enterPassword(password);
        loginPage.selectDay(day);
        loginPage.selectMonth(month);
        loginPage.selectYear(year);
        loginPage.selectNewsletterCheckbox();
        loginPage.selectSpecialOffersCheckbox();
        loginPage.enterFirstName(firtsName);
        loginPage.enterLastName(lastName);
        loginPage.enterCompany(company);
        loginPage.enterAddress(address);
        loginPage.enterAddress2(address2);
        loginPage.selectCountry(country);
        loginPage.enterState(state);
        loginPage.enterCity(city);
        loginPage.enterZipCode(zipCode);
        loginPage.enterMobilePhone(mobilePhone);
        loginPage.clickCreateAccountButton();
        loginPage.isAccountCreatedVisible();
        loginPage.clickContinueButton();
        loginPage.isUserLoggedIn();
        loginPage.clickDeleteAccount();
        loginPage.isAccountDeletedVisible();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
