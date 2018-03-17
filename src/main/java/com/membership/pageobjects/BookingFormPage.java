package com.membership.pageobjects;

import com.github.javafaker.Faker;
import com.membership.Visitor;
import com.membership.projectresouces.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.java2d.loops.GeneralRenderer;

import java.util.List;

public class BookingFormPage extends BasePage {

    String firstName = ("firstname");
    String lastName = ("lastname");
    String deposit =  ("totalprice");
    String checkInDate = ("checkin");
    String checkOutDate = ("checkout");
    String saveButton = ("#form > div > div:nth-child(7) > input[type=\"button\"]");

    public void open() throws InterruptedException {
        getDriver().get("http://hotel-test.equalexperts.io/");
        wait(2);

    }

    public void createNewVsitor() throws Exception {

        //Faker faker = new Faker();
        type(Locators.id, firstName, "Jon");
        type(Locators.id, lastName, "Simm");
        type(Locators.id, deposit, "10");
        type(Locators.id, checkInDate, "2018-04-01");
        type(Locators.id, checkOutDate, "2018-04-05");
        click(Locators.css, saveButton);
        wait(5);
    }

    public void findBooking(){
        getDriver().findElements(By.xpath(("//div[contains(@class, 'row') and contains(., 'Simm')]")));

    }

    public void deleteMyBooking(){

        WebElement mybutton = getDriver().findElement(By.xpath(("//div[contains(@class, 'row') and contains(., 'Simm')]//input[@type='button'][contains(@value, 'Delete')]")));
        mybutton.click();

    }



}
