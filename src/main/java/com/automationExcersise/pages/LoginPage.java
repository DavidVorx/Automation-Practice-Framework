package com.automationExcersise.pages;

import com.automationExcersise.utils.BrowserActions;
import com.automationExcersise.utils.CsvDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class LoginPage{

    private BrowserActions browserActions;
    private CsvDataReader csvDataReader;

    public LoginPage(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        csvDataReader = new CsvDataReader("src/main/resources/objects/xpaths.csv");
    }

    public void enterUsername(String userName) {
        String usernameXpath = csvDataReader.getData("loginPage.userNameInput");
        browserActions.enterTextByXPath(usernameXpath, userName);
    }

    public void enterEmail(String email) {
        String emailXpath = csvDataReader.getData("loginPage.emailInput");
        browserActions.enterTextByXPath(emailXpath, email);
    }

    public void clickSingupButton() {
        String singupButtonXpath = csvDataReader.getData("loginPage.signupButton");
        browserActions.clickElementByXPath(singupButtonXpath);
    }

    public boolean isEnterAccountVisible() {
        String enterAccountXpath = csvDataReader.getData("loginPage.enterAccountInformation");
        System.out.println("Checking if element is visible: " + enterAccountXpath);
        return browserActions.isElementVisible(enterAccountXpath);
    }

    public void clickGenderMale(){
        String genderRadioButtonXpath = csvDataReader.getData("loginPage.genderMale");
        browserActions.clickElementByXPath(genderRadioButtonXpath);
    }

    public void enterPassword(String password){
        String passwordXpath = csvDataReader.getData("loginPage.passwordInput");
        browserActions.enterTextByXPath(passwordXpath, password);
    }

    public void selectDay(String day) {
        String dayDatePickerXpath = csvDataReader.getData("loginPage.selectDay");
        System.out.println("Estamos en el selectDay" + dayDatePickerXpath);
        WebElement dayDatePicker = browserActions.findElementByXPath(dayDatePickerXpath);
        Select selectDay = new Select(dayDatePicker);
        selectDay.selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        String monthDatePickerXpath = csvDataReader.getData("loginPage.selectMonth");
        WebElement monthDatePicker = browserActions.findElementByXPath(monthDatePickerXpath);
        Select selectMonth = new Select(monthDatePicker);
        selectMonth.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        String yearDatePickerXpath = csvDataReader.getData("loginPage.selectYear");
        WebElement yearDatePicker = browserActions.findElementByXPath(yearDatePickerXpath);
        Select selectYear = new Select(yearDatePicker);
        selectYear.selectByVisibleText(year);
    }

    public void selectNewsletterCheckbox() {
        String newsletterCheckboxXpath = csvDataReader.getData("loginPage.newsletterCheckbox");
        browserActions.scrollToElementByXPath(newsletterCheckboxXpath);
        browserActions.clickElementByXPath(newsletterCheckboxXpath);
    }

    public void selectSpecialOffersCheckbox() {
        String specialOffersCheckboxXpath = csvDataReader.getData("loginPage.specialOffersCheckbox");
        browserActions.scrollToElementByXPath(specialOffersCheckboxXpath);
        browserActions.clickElementByXPath(specialOffersCheckboxXpath);
    }

    public void enterFirstName(String firstName) {
        String firstNameXpath = csvDataReader.getData("loginPage.firstNameInput");
        browserActions.scrollToElementByXPath(firstNameXpath);
        browserActions.enterTextByXPath(firstNameXpath, firstName);
    }

    public void enterLastName(String lastName) {
        String lastNameXpath = csvDataReader.getData("loginPage.lastNameInput");
        browserActions.scrollToElementByXPath(lastNameXpath);
        browserActions.enterTextByXPath(lastNameXpath, lastName);
    }

    public void enterCompany(String company) {
        String companyXpath = csvDataReader.getData("loginPage.companyInput");
        browserActions.scrollToElementByXPath(companyXpath);
        browserActions.enterTextByXPath(companyXpath, company);
    }

    public void enterAddress(String address) {
        String addressXpath = csvDataReader.getData("loginPage.addressInput");
        browserActions.scrollToElementByXPath(addressXpath);
        browserActions.enterTextByXPath(addressXpath, address);
    }

    public void enterAddress2(String address2) {
        String address2Xpath = csvDataReader.getData("loginPage.address2Input");
        browserActions.scrollToElementByXPath(address2Xpath);
        browserActions.enterTextByXPath(address2Xpath, address2);
    }

    public void selectCountry(String country){
        String countrySelectXpath = csvDataReader.getData("loginPage.countrySelect");
        WebElement countrySelect = browserActions.findElementByXPath(countrySelectXpath);
        Select selectCountry = new Select(countrySelect);
        selectCountry.selectByVisibleText(country);
    }

    public void enterState(String state) {
        String stateXpath = csvDataReader.getData("loginPage.stateInput");
        browserActions.scrollToElementByXPath(stateXpath);
        browserActions.enterTextByXPath(stateXpath, state);
    }

    public void enterCity(String city) {
        String cityXpath = csvDataReader.getData("loginPage.cityInput");
        browserActions.scrollToElementByXPath(cityXpath);
        browserActions.enterTextByXPath(cityXpath, city);
    }

    public void enterZipCode(String zipCode) {
        String zipCodeXpath = csvDataReader.getData("loginPage.zipCodeInput");
        browserActions.scrollToElementByXPath(zipCodeXpath);
        browserActions.enterTextByXPath(zipCodeXpath, zipCode);
    }

    public void enterMobilePhone(String mobilePhone) {
        String mobilePhoneXpath = csvDataReader.getData("loginPage.mobilePhoneInput");
        browserActions.scrollToElementByXPath(mobilePhoneXpath);
        browserActions.enterTextByXPath(mobilePhoneXpath, mobilePhone);
    }

    public void clickCreateAccountButton() {
        String createAccountButtonXpath = csvDataReader.getData("loginPage.createAccountButton");
        browserActions.clickElementByXPath(createAccountButtonXpath);
    }

    public boolean isAccountCreatedVisible() {
        String accountCreatedXpath = csvDataReader.getData("loginPage.accountCreationSuccess");
        System.out.println("Checking if element is visible: " + accountCreatedXpath);
        return browserActions.isElementVisible(accountCreatedXpath);
    }

    public void clickContinueButton() {
        String continueButtonXpath = csvDataReader.getData("loginPage.continueButton");
        browserActions.clickElementByXPath(continueButtonXpath);
    }

    public boolean isUserLoggedIn() {
        String userLoggedInXpath = csvDataReader.getData("loginPage.accountValidationText");
        System.out.println("Checking if element is visible: " + userLoggedInXpath);
        return browserActions.isElementVisible(userLoggedInXpath);
    }

    public void clickDeleteAccount(){
        String deleteAccountXpath = csvDataReader.getData("loginPage.deleteAccountButtton");
        browserActions.clickElementByXPath(deleteAccountXpath);
    }

    public boolean isAccountDeletedVisible(){
        String accountDeletedXpath = csvDataReader.getData("loginPage.accountDeletedText");
        System.out.println("Checking if element is visible: " + accountDeletedXpath);
        return browserActions.isElementVisible(accountDeletedXpath);
    }
}
