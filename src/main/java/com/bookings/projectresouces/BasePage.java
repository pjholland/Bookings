package com.bookings.projectresouces;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasePage {

    public enum Locators {
        xpath, id, name, classname, paritallinktext, linktext, tagname, css,
    }

    protected WebDriver getDriver() {

        // Run the required browser dependent on the status of the environment variable
        String  a = String.valueOf(System.getenv("ENV1"));

        if (a.equals("chrome_driver"))
        {
            return webDriverSingleton.getInstance(webDriverSingleton.Browsers.chrome);
        }
        else
            {
            return webDriverSingleton.getInstance(webDriverSingleton.Browsers.firefox);
        }
    }

    ///////////////////////////////////////////
    // WebDriver Standard Functionality
    //////////////////////////////////////////

    public void takeScreenshot() throws Exception {
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/screenShots/failed-test.png"));
    }
    
    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void navigateForward() {
        getDriver().navigate().forward();
    }

    public void confirmPageTitle(String title) {
        assertTrue(getDriver().getTitle().contains(title));
    }

    public void switchToFrame(String frameId) {
        getDriver().switchTo().frame(frameId);
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public void determinePageTitle(String pageTitle){

        String actualTitle = getDriver().getTitle();
        assertEquals(actualTitle, pageTitle);
    }

    /////////////////////////////////////////
    //waiting functionality
    /////////////////////////////////////////

    //a method for allowing selenium to pause for a set amount of time - used primarily for debugging
    protected void waitForExecution() throws InterruptedException {
        int seconds = 0;
        Thread.sleep(seconds * 1000);
    }

    //methods for waiting until an element is displayed
    protected void waitForElementDisplayed(Locators locator, String element, int seconds) throws Exception {
        waitForElementDisplayed(getWebElement(locator, element), seconds);
    }

    public void waitForElementDisplayed(WebElement element) throws Exception {
        waitForElementDisplayed(element, 5);
    }

    private void waitForElementDisplayed(WebElement element, int seconds) throws Exception {
        //wait for up to XX seconds for our error message
        long end = System.currentTimeMillis() + (seconds * 1000);
        while (System.currentTimeMillis() < end) {
            if (element.isDisplayed()) break;
        }
    }

    /////////////////////////////////////
    //selenium actions functionality
    /////////////////////////////////////

    //our generic selenium click functionality implemented - this method uses our custom process
    protected void click(Locators locator, String element) throws Exception {
        click(getWebElement(locator, element));
    }

    // This method uses the traditional WebElement class
    private void click(WebElement element) {
        Actions selAction = new Actions(getDriver());
        selAction.click(element).perform();
    }

    //method to simulate the mouse hovering over an element - uses the tradtional WebElement class
    private void hover(WebElement element) throws Exception {
        Actions selAction = new Actions(getDriver());
        selAction.moveToElement(element).perform();
    }

    //our generic selenium type functionality - uses our Base Class getWebElement method
    protected void type(Locators locator, String element, String text) throws Exception {
        type(getWebElement(locator, element), text);
    }

    //  uses our Base Class getWebElement method
    private void type(WebElement element, String text) {
        Actions selAction = new Actions(getDriver());
        selAction.sendKeys(element, text).perform();
    }

    // if this method is used then the element type in the page object be should String and not WebDriver By - hybrid - needs refactoring
    protected void selectFromDropDownList(String dropDownId, String dropDownRowName) {
        Select dropdown = new Select(getDriver().findElement(By.id(dropDownId)));
        dropdown.selectByVisibleText(dropDownRowName);
    }

    // Method to confirm that element has text - uses our Base Class getWebElement process
    public void elementHasText(Locators locator, String element, String elementText) throws Exception {
        String actualString = getWebElement(locator, element).getText();
        assertTrue(actualString.contains(elementText));
    }

    //  uses our Base Class getWebElement process
    public void getElementText(Locators locator, String element) throws Exception {
        String actualString = getWebElement(locator, element).getText();
        System.out.print(actualString);
    }

    // Methods to enable and disable check box - cannot fully utilise our Base class due to the boolean operator
    public void enableCheckBox(Locators locator, String element) throws Exception {

        if (!getDriver().findElement((By) getWebElement(locator, element)).isSelected()) {
            getDriver().findElement((By) getWebElement(locator, element)).click();
        }
    }

    public void disableCheckBox(Locators locator, String element) throws Exception {

        if (getDriver().findElement((By) getWebElement(locator, element)).isSelected()) {
            getDriver().findElement((By) getWebElement(locator, element)).click();
        }
    }

    /////////////////////////////////////
    //Other Generic Tests
    ////////////////////////////////////

    // Method to check text is visible on the page - has limitations as it looks at the page source
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void checkTextPresentOnPage(String text) {
        getDriver().getPageSource().compareTo(text);
    }


    ////////////////////////////////////
    //extra base selenium functionality
    ////////////////////////////////////

    //a method to grab the web element using selenium WebDriver
    private WebElement getWebElement(Locators locator, String element) throws Exception {
        By byElement;
        switch (locator) {        //determine which locator item we are interested in
            case xpath: {
                byElement = By.xpath(element);
                break;
            }
            case css: {
                byElement = By.cssSelector(element);
                break;
            }
            case id: {
                byElement = By.id(element);
                break;
            }
            case name: {
                byElement = By.name(element);
                break;
            }
            case classname: {
                byElement = By.className(element);
                break;
            }
            case linktext: {
                byElement = By.linkText(element);
                break;
            }
            case paritallinktext: {
                byElement = By.partialLinkText(element);
                break;
            }
            case tagname: {
                byElement = By.tagName(element);
                break;
            }
            default: {
                throw new Exception();
            }
        }
        return getDriver().findElement(byElement);    //return our query

    }
}
