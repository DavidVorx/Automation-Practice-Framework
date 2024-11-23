package com.automationExcersise.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(String url) {
        try {
            System.out.println("Navigating to: " + url);
            driver.get(url);
        } catch (Exception e) {
            System.err.println("Error while trying to enter " + url);
            e.printStackTrace();
        }
    }

    public static WebDriver setupDriver() {
        try {
            System.out.println("Setting up WebDriver...");
            // Set path to ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\david\\Downloads\\chromedriver.exe");
            // Configure ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");
            // Initialize WebDriver with ChromeOptions
            WebDriver driver = new ChromeDriver(options);
            System.out.println("WebDriver setup complete.");
            System.out.println("Maximizing the browser window");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;

        } catch (Exception e) {
            System.err.println("Error while setting up WebDriver.");
            e.printStackTrace();
            return null;
        }
    }

    // Method to maximize the window
    public void maximizeWindow() {
        try {
            System.out.println("Maximizing the browser window");
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.err.println("Error while trying to maximize the window");
            e.printStackTrace();
        }
    }

    // Method to find an Xpath element
    public WebElement findElementByXPath(String xpath) {
        try {
            System.out.println("Finding an element with " + xpath);
            return driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            System.err.println("Error while trying to find the element " + xpath);
            e.printStackTrace();
            return null;
        }
    }

    // Method to enter text in an element
    public void enterTextByXPath(String xpath, String text) {
        try {
            System.out.println("Writing in the xpath element" + xpath);
            WebElement element = findElementByXPath(xpath);
            if (element != null) {
                element.sendKeys(text);
            }
        } catch (Exception e) {
            System.err.println("Error while trying to write text in the element with XPath: " + xpath);
            e.printStackTrace();
        }
    }

    // Method to click an element
    public void clickElementByXPath(String xpath) {
        try {
            System.out.println("Clicking -> " + xpath);
            WebElement element = findElementByXPath(xpath);
            if (element != null) {
                element.click();
            }
        } catch (Exception e) {
            System.err.println("Error while trying to click the xpath element" + xpath);
            e.printStackTrace();
        }
    }

    // Method to wait for an element to be visible
    public void waitForElement(String xpath) {
        try {
            System.out.println("Waiting for the element " + xpath + " to be visible");
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (TimeoutException e) {
            System.err.println("Error: Tiempo de espera excedido para el elemento " + xpath);
            throw e; // Re-throw the exception
        }
    }

    // Method to check if an element is not visible
    public boolean isElementNotVisible(String xpath) {
        try {
            System.out.println("Checking if element " + xpath + " is not visible");
            return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        } catch (TimeoutException e) {
            System.err.println("Element " + xpath + " is still visible after waiting");
            return false;
        }
    }

    // Method to check if an element is visible
    public boolean isElementVisible(String xpath) {
        try {
            System.out.println("Checking if element " + xpath + " is visible");
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return element != null;
        } catch (TimeoutException e) {
            System.err.println("Element " + xpath + " is not visible after waiting");
            return false;
        }
    }

    // Method to scroll to an element
    public void scrollToElementByXPath(String xpath) {
        try {
            System.out.println("Scrolling to element with XPath: " + xpath);
            WebElement element = findElementByXPath(xpath);
            if (element != null) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element);
            }
        } catch (Exception e) {
            System.err.println("Error while trying to scroll to the element with XPath: " + xpath);
            e.printStackTrace();
        }
    }

    // Method to get the WebDriver
    public WebDriver getDriver() {
        return driver;
    }
}
