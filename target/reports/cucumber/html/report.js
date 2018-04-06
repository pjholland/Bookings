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
  "duration": 3201100195,
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
  "duration": 2238771817,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.their_booking_will_appear_on_the_form()"
});
formatter.result({
  "duration": 3471335183,
  "status": "passed"
});
formatter.after({
  "duration": 4906970,
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
  "duration": 367826319,
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
  "duration": 1226887653,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.each_booking_will_have_a_Delete_button()"
});
formatter.result({
  "duration": 112075273,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.their_booking_will_appear_on_the_form()"
});
formatter.result({
  "duration": 2713528499,
  "status": "passed"
});
formatter.after({
  "duration": 66001,
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
  "duration": 348289791,
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
  "duration": 4851412676,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.the_booking_will_no_longer_be_visible_on_the_form()"
});
formatter.result({
  "duration": 74834503,
  "status": "passed"
});
formatter.after({
  "duration": 39908,
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
  "duration": 430437405,
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
  "duration": 892787695,
  "status": "passed"
});
formatter.match({
  "location": "BookingFormStep.the_booking_will_not_be_made()"
});
formatter.result({
  "duration": 20292724,
  "status": "passed"
});
formatter.after({
  "duration": 44088,
  "status": "passed"
});
});