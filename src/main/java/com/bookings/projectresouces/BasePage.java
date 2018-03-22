package com.bookings.projectresouces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class BasePage {

    public enum Locators {
        xpath, id, name, classname, paritallinktext, linktext, tagname, css,
    }

    protected WebDriver getDriver() {
        return webDriverSingleton.getInstance();

    }

    ///////////////////////////////////////////
    // WebDriver Standard Functionality
    //////////////////////////////////////////

    public void navigateTo(String url){
        getDriver().navigate().to(url);
    }

    public void navigateBack(){
        getDriver().navigate().back();
    }

    public void navigateforward(){
        getDriver().navigate().forward();
    }

    public void confirmPageTitle(String title){
        assertTrue(getDriver().getTitle().contains(title));
    }

    public void switchToFrame(String frameId){
        getDriver().switchTo().frame(frameId);
    }

    public void switchToDefaultContent(){
        getDriver().switchTo().defaultContent();
    }

    /////////////////////////////////////////
    //waiting functionality
    /////////////////////////////////////////

    //a method for allowing selenium to pause for a set amount of time - used primarily for debugging
    protected void wait(int seconds) throws InterruptedException {
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

    //our generic selenium click functionality implemented
    protected void click(Locators locator, String element) throws Exception {
        click(getWebElement(locator, element));
    }

    private void click(WebElement element) {
        Actions selAction = new Actions(getDriver());
        selAction.click(element).perform();
    }

    //method to simulate the mouse hovering over an element
    private void hover(WebElement element) throws Exception {
        Actions selAction = new Actions(getDriver());
        selAction.moveToElement(element).perform();
    }

    //our generic selenium type functionality
    protected void type(Locators locator, String element, String text) throws Exception {
        type(getWebElement(locator, element), text);
    }

    private void type(WebElement element, String text) {
        Actions selAction = new Actions(getDriver());
        selAction.sendKeys(element, text).perform();
    }

    // if this method is used then the element type in the page object be should String and not WebDriver By
    protected void selectFromDropDownList(String dropDownId, String dropDownRowName) {
        Select dropdown = new Select(getDriver().findElement(By.id(dropDownId)));
        dropdown.selectByVisibleText(dropDownRowName);
    }

    // Method to confirm that element has text Note find element was cast to By
    public void elementHasText(Locators locator, String element, String elementText) throws Exception {
        String actualString = getDriver().findElement((By) getWebElement(locator, element )).getText();
        assertTrue(actualString.contains(elementText));

    }

    // Methods to enable and disable check box
    public void enableCheckBox(Locators locator, String element) throws Exception {

        if ( !getDriver().findElement((By) getWebElement(locator, element )).isSelected() )
        {
             getDriver().findElement((By) getWebElement(locator, element )).click();
        }
    }

    public void disableCheckBox(Locators locator, String element) throws Exception {

        if ( getDriver().findElement((By) getWebElement(locator, element )).isSelected() )
        {
            getDriver().findElement((By) getWebElement(locator, element )).click();
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
