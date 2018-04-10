$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotel_booking_form.feature");
formatter.feature({
  "line": 2,
  "name": "Hotel Booking Form",
  "description": "\n      In order to maintain an on-line booking service\n      I want a Booking Form web page\n      So that visitors can book their accommodation on line",
  "id": "hotel-booking-form",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@current"
    }
  ]
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the visitor is on the hotel booking form page",
  "keyword": "Given "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_is_on_the_hotel_booking_form_page()"
});
formatter.result({
  "duration": 3753392581,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "An online visitor can book a hotel room",
  "description": "",
  "id": "hotel-booking-form;an-online-visitor-can-book-a-hotel-room",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "the visitor makes a booking",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "their booking will appear on the form",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_makes_a_booking()"
});
formatter.result({
  "duration": 1725591255,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.their_booking_will_appear_on_the_form()"
});
formatter.result({
  "duration": 4064451935,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the visitor is on the hotel booking form page",
  "keyword": "Given "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_is_on_the_hotel_booking_form_page()"
});
formatter.result({
  "duration": 369988525,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Each booking will have an associated Delete button",
  "description": "",
  "id": "hotel-booking-form;each-booking-will-have-an-associated-delete-button",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "the visitor makes a booking",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "each booking will have a Delete button",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "their booking will appear on the form",
  "keyword": "And "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_makes_a_booking()"
});
formatter.result({
  "duration": 1192419976,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.each_booking_will_have_a_Delete_button()"
});
formatter.result({
  "duration": 63415209,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.their_booking_will_appear_on_the_form()"
});
formatter.result({
  "duration": 1290632535,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the visitor is on the hotel booking form page",
  "keyword": "Given "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_is_on_the_hotel_booking_form_page()"
});
formatter.result({
  "duration": 270416589,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "An on line visitor can delete their booking",
  "description": "",
  "id": "hotel-booking-form;an-on-line-visitor-can-delete-their-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "the visitor decides to delete their booking",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the booking will no longer be visible on the form",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_decides_to_delete_their_booking()"
});
formatter.result({
  "duration": 4564102621,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.the_booking_will_no_longer_be_visible_on_the_form()"
});
formatter.result({
  "duration": 39430795,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the visitor is on the hotel booking form page",
  "keyword": "Given "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_is_on_the_hotel_booking_form_page()"
});
formatter.result({
  "duration": 285647261,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "An online visitor is must fill in all fields before making a booking",
  "description": "",
  "id": "hotel-booking-form;an-online-visitor-is-must-fill-in-all-fields-before-making-a-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "the visitor attempts to save the booking form without completing all fields",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "the booking will not be made",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingFormStep.the_visitor_attempts_to_save_the_booking_form_without_completing_all_fields()"
});
formatter.result({
  "duration": 394151845,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.the_booking_will_not_be_made()"
});
formatter.result({
  "duration": 18296818,
  "status": "passed"
});
});