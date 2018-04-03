package com.bookings.pageobjects;

import com.bookings.Visitor;
import com.bookings.projectresouces.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookingFormPage extends BasePage {

    String firstName = ("firstname");
    String lastName = ("lastname");
    String totalPrice =  ("totalprice");
    String deposit = ("depositpaid");
    String checkInDate = ("checkin");
    String checkOutDate = ("checkout");
    String saveButton = ("#form > div > div:nth-child(7) > input[type=\"button\"]");

    public void open() {
        // Note hard coded URL used here - this would not happen in production code
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

        // Find our booking using a Xpath Query on the form and confirm that the information is correct
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'Jon')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'Simm')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., '99.99')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'false')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., '2018-05-01')]")));
        getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., '2018-05-05')]")));
    }

    public void deleteMyBooking(){
        // Wait for booking to appear and then click the Delete button for that booking
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("bookings"), "Simm"));
        WebElement mybutton = getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'Simm')]//input[@type='button'][contains(@value, 'Delete')]")));
        mybutton.click();
    }

    public void bookingIsNotVisible(){
        getDriver().findElements(By.xpath(("//div[not(contains(@class, 'row') and contains(., 'Simm'))]")));
    }

    public void makeAnIncompleteBooking() throws Exception {
        type(Locators.id, firstName, "Jon");
        type(Locators.id, lastName, "Simm");
        click(Locators.css, saveButton);
    }

    public void eachBookingHasADeleteButton(){
        // Get the total number of rows from the form
        int totalNumberOfRows;
        totalNumberOfRows = getDriver().findElements(By.xpath("//div[contains(@class, 'row')]")).size();
        // Do not include the header row and the input row
        int rowsMinusFirstAndLastRow = totalNumberOfRows - 2;
        // Get the total number of rows with a Delete button
        int totalNumberOfRowsWithDeleteButton;
        totalNumberOfRowsWithDeleteButton  = getDriver().findElements(By.xpath("//input[@type='button'][contains(@value, 'Delete')]")).size();
        // Assert that the two variable are the same and confirm that the test passes
        assertEquals(rowsMinusFirstAndLastRow,totalNumberOfRowsWithDeleteButton);
    }

    public void deleteAllBookings() throws InterruptedException {
        // Need sleeps here to allow for stale element reference
        wait(2);
        List<WebElement> deleteButtons = getDriver().findElements(By.xpath("//*[@value=\"Delete\"]"));

        for(int i = 0; i < deleteButtons.size(); ++i) {
            wait(2);
            WebElement buttons = deleteButtons.get(i).findElement(By.xpath("//*[@value=\"Delete\"]"));
            wait(2);
            buttons.click();
        }
    }

    // Not implemented yet - needs more work
    public void createVisitorWithUniqueName() throws Exception {

        Visitor visitor = new Visitor();

        type(Locators.id, firstName, visitor.getFirstName());
        type(Locators.id, lastName, visitor.getLastName());
        type(Locators.id, totalPrice, "99.99");
        selectFromDropDownList(deposit, "false");
        type(Locators.id, checkInDate, "2018-05-01");
        type(Locators.id, checkOutDate, "2018-05-05");
        click(Locators.css, saveButton);
    }

    public void createDefaultBooking() throws Exception {
        // if no bookings exist then create a deault booking
        int currentBookings = getDriver().findElements(By.xpath("//input[@type='button'][contains(@value, 'Delete')]")).size();

        if (currentBookings < 1) {
            type(Locators.id, firstName, "Mary");
            type(Locators.id, lastName, "Jones");
            type(Locators.id, totalPrice, "99.99");
            selectFromDropDownList(deposit, "false");
            type(Locators.id, checkInDate, "2018-05-01");
            type(Locators.id, checkOutDate, "2018-05-05");
            click(Locators.css, saveButton);
            // Wait for the default booking information to appear on the form
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            wait.until(ExpectedConditions.textToBePresentInElement(By.id("bookings"), "Jones"));
        }else {
            if (currentBookings ==1)
                System.out.print("A default booking exists...... ");
        }
    }
}





