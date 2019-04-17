package com.test;

import com.todoist.WebElements.HomePage;
import com.todoist.capabilities.androidCap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MobileBrowser extends androidCap  {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    private static int TIMEOUT = 15;

    // Page object class
    HomePage homePage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = ChromeCapabilities();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    @Test
    public void gotoPage() {
        driver.get("https://en.todoist.com/");
        wait.until(ExpectedConditions
            .visibilityOf(homePage.getStartedBtn));
        homePage.getStartedBtn.click();
    }

}
