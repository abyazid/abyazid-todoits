package com.test;

import com.todoist.PageObjects.LoginPage;
import com.todoist.capabilities.androidCap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CreateProject extends androidCap {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    private static int TIMEOUT = 15;

    // Page object class
    LoginPage loginPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = MobileCapabilities();
        wait = new WebDriverWait(driver, TIMEOUT);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void userLogin() {
        // Wait for Todoist logo to be loaded
        wait.until(ExpectedConditions
            .visibilityOf(loginPage.TodoistLogo));
        loginPage.btnEmailSignIn.click();
    }
}
