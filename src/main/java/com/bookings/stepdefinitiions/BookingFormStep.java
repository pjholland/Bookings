package com.bookings.stepdefinitiions;

import com.bookings.pageobjects.BookingFormPage;
import com.bookings.projectresouces.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingFormStep {

    private BookingFormPage bookingFormPage;

    @Given("^the visitor is on the hotel booking form page$")
    public void the_visitor_is_on_the_hotel_booking_form_page() throws Throwable {
        bookingFormPage = new BookingFormPage();
        bookingFormPage.open();
        // Create deault booking if no bookings exist
        bookingFormPage.createDefaultBooking();
    }

    @And("^the visitor makes a booking$")
    public void the_visitor_makes_a_booking() throws Throwable {
        bookingFormPage.createNewVsitor();
            // Method below allows us to create a unique user
        // bookingFormPage.createVisitorWithUniqueName();
    }

    @Then("^their booking will appear on the form$")
    public void their_booking_will_appear_on_the_form() throws Throwable {
        bookingFormPage.findBooking();
        // Remove visitor after creation
        bookingFormPage.deleteMyBooking();
    }

    @Given("^the visitor decides to delete their booking$")
    public void the_visitor_decides_to_delete_their_booking() throws Throwable {
        bookingFormPage.createNewVsitor();
        bookingFormPage.deleteMyBooking();
    }

    @Then("^the booking will no longer be visible on the form$")
    public void the_booking_will_no_longer_be_visible_on_the_form() throws Throwable {
        bookingFormPage.bookingIsNotVisible();
    }

    @When("^the visitor attempts to save the booking form without completing all fields$")
    public void the_visitor_attempts_to_save_the_booking_form_without_completing_all_fields() throws Throwable {
        bookingFormPage.makeAnIncompleteBooking();
    }

    @Then("^the booking will not be made$")
    public void the_booking_will_not_be_made() throws Throwable {
       bookingFormPage.bookingIsNotVisible();
    }

    @Then("^each booking will have a Delete button$")
    public void each_booking_will_have_a_Delete_button() throws Throwable {
       bookingFormPage.eachBookingHasADeleteButton();
    }

}
