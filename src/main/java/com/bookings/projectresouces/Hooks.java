package com.bookings.projectresouces;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hooks extends BasePage {

   @After
    public void tearDown(){
        getDriver().quit();
    }

    // Takes screen shot for a scenario or feature - enter tag into brackets e.g. @current
    // @After ()
    public static void embedScreenshot(Scenario scenario) {
        scenario.write("We are here");
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)webDriverSingleton.getInstance(webDriverSingleton.Browsers.chrome)).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

    // Global screenshot taker - takes screenshot after each fail
    @After
    public void tearDown(Scenario result)
    {
        //on failure, embed a screenshot in the test report
        if(result.isFailed())
        {
            byte[] screenshot =  ((TakesScreenshot)webDriverSingleton.getInstance(webDriverSingleton.Browsers.chrome))
                    .getScreenshotAs(OutputType.BYTES);

            result.embed(screenshot, "image/png");
        }
        //stop the browser session
       // webDriverSingleton.getInstance(webDriverSingleton.Browsers.chrome).quit();
    }

    @After("@leave_window_open")
    public void leave_window_open(Scenario scenario) {
        if (scenario.isFailed()) {

            System.out.println("Step failed. Press ENTER to close browser...");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}