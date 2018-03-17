package com.membership.projectresouces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class webDriverSingleton {
    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }

        return driver;

    }

}
