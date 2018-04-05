package com.bookings.pageobjects;

import com.bookings.Visitor;
import com.bookings.projectresouces.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class BookingFormPage extends BasePage {

    String firstName    = ("firstname");
    String lastName     = ("lastname");
    String totalPrice   = ("totalprice");
    String deposit      = ("depositpaid");
    String checkInDate  = ("checkin");
    String checkOutDate = ("checkout");
    String saveButton   = ("#form > div > div:nth-child(7) > input[type=\"button\"]");

    public void open() {
        // Note hard coded URL used here - this would not happen in production code
        getDriver().get("http://hotel-test.equalexperts.io/");
        
        // When the form loads wait for for the first input elements to become clickable
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
    }

    public void findUniqueBooking(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("bookings"), Visitor.createTestVsitor().getFirstName()));
    }

    public void deleteUniqueBooking()  {
        // Get last name from the visitor class
        String uniqueVisitorLastName = Visitor.createTestVsitor().getLastName();
        // This string interpolates the last name into the xpath string and allows the deletion of the unique visitor
        String xpathString = String.format("//div[contains(@class, 'row') and contains(., '%s')]//input[@type='button'][contains(@value, 'Delete')]", uniqueVisitorLastName);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("bookings"), Visitor.createTestVsitor().getLastName()));
        WebElement deleteButton = getDriver().findElement(By.xpath(xpathString));
        deleteButton.click();
    }

    public void bookingIsNotVisible(){
        String uniqueVisitorLastName = Visitor.createTestVsitor().getLastName();
        String xpathString = String.format("//div[not(contains(@class, 'row') and contains(., '%s'))]", uniqueVisitorLastName);
        getDriver().findElement(By.xpath(xpathString));
    }

    public void makeAnIncompleteBooking() throws Exception {
        type(Locators.id, firstName, Visitor.createTestVsitor().getFirstName());
        type(Locators.id, lastName, Visitor.createTestVsitor().getLastName());
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
        // Need sleep here to allow for stale element reference
        wait(2);
        List<WebElement> deleteButtons = getDriver().findElements(By.xpath("//*[@value=\"Delete\"]"));

        for(int i = 0; i < deleteButtons.size(); ++i) {
            wait(2);
            WebElement buttons = deleteButtons.get(i).findElement(By.xpath("//*[@value=\"Delete\"]"));
            wait(2);
            buttons.click();
        }
    }

    public void createVisitorWithUniqueName() throws Exception {

        Visitor visitor  = Visitor.createTestVsitor();

        type(Locators.id, firstName, visitor.getFirstName());
        type(Locators.id, lastName, visitor.getLastName());
        type(Locators.id, totalPrice, "99.99");
        selectFromDropDownList(deposit, "false");
        type(Locators.id, checkInDate, "2018-05-01");
        type(Locators.id, checkOutDate, "2018-05-05");
        click(Locators.css, saveButton);
    }

    public void createDefaultBooking() throws Exception {
        // if no bookings exist then create a default booking
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
        }
    }
}





