package com.membership.pageobjects;

import com.membership.projectresouces.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingFormPage extends BasePage {

    String firstName = ("firstname");
    String lastName = ("lastname");
    String totalPrice =  ("totalprice");
    String deposit = ("depositpaid");
    String checkInDate = ("checkin");
    String checkOutDate = ("checkout");
    String saveButton = ("#form > div > div:nth-child(7) > input[type=\"button\"]");

    public void open() throws InterruptedException {
        getDriver().get("http://hotel-test.equalexperts.io/");

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));

    }

    public void createNewVsitor() throws Exception {
        wait(2);
        type(Locators.id, firstName, "Jon");
        type(Locators.id, lastName, "Simm");
        type(Locators.id, totalPrice, "10");
        selectFromDropDownList(deposit, "false");
        wait(3);
        type(Locators.id, checkInDate, "2018-04-01");
        type(Locators.id, checkOutDate, "2018-04-05");
        click(Locators.css, saveButton);
    }

    public void findBooking(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("bookings"), "Simm"));
        getDriver().findElements(By.xpath(("//div[contains(@class, 'row') and contains(., 'Simm')]")));
        getDriver().findElements(By.xpath(("//div[contains(@class, 'row') and contains(., 'false')]")));
    }

    public void deleteMyBooking(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("bookings"), "Simm"));
        WebElement mybutton = getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'Simm')]//input[@type='button'][contains(@value, 'Delete')]")));
        mybutton.click();

    }

    public void bookingIsNotVisible(){
        getDriver().findElements(By.xpath(("//div[not(contains(@class, 'row') and contains(., 'Simm'))]")));
    }

}
