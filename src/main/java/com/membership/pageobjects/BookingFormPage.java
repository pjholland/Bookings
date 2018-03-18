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
        // When the form loads wait for for the first input elements to become clickable
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));

    }

    public void createNewVsitor() throws Exception {
        type(Locators.id, firstName, "Jon");
        type(Locators.id, lastName, "Simm");
        type(Locators.id, totalPrice, "99.99");
        selectFromDropDownList(deposit, "false");
        type(Locators.id, checkInDate, "2018-05-01");
        type(Locators.id, checkOutDate, "2018-05-05");
        click(Locators.css, saveButton);
    }

    public void findBooking(){
        // Wait for the booking information to appear on the form
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("bookings"), "Simm"));

        // Find our booing on the form and confirm that the information is correct
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'Jon')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'Simm')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., '99.99')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'false')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., '2018-05-01')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., '2018-05-05')]")));
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
