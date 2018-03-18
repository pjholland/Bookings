package com.membership.stepdefinitiions;

import com.membership.pageobjects.BookingFormPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BookingFormStep {

    private BookingFormPage bookingFormPage;


    @Given("^the visitor is on the hotel booking form page$")
    public void the_visitor_is_on_the_hotel_booking_form_page() throws Throwable {
        bookingFormPage = new BookingFormPage();
        bookingFormPage.open();
    }

    @And("^the visitor makes a booking$")
    public void the_visitor_makes_a_booking() throws Throwable {
        bookingFormPage.createNewVsitor();
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

    @Then("^the booking will no longer be visible on the fom$")
    public void the_booking_will_no_longer_be_visible_on_the_fom() throws Throwable {
        bookingFormPage.bookingIsNotVisible();
    }

}
