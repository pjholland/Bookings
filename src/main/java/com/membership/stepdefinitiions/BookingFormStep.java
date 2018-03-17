package com.membership.stepdefinitiions;

import com.membership.pageobjects.BookingFormPage;
import com.membership.Visitor;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.sql.Driver;

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
        bookingFormPage.deleteMyBooking();
    }

}
