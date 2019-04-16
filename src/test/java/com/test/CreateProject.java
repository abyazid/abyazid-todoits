package com.test;

import com.todoist.PageObjects.HomePage;
import com.todoist.PageObjects.LoginPage;
import com.todoist.capabilities.androidCap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
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
    HomePage homePage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = MobileCapabilities();
        wait = new WebDriverWait(driver, TIMEOUT);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void userLogin() {
        // Wait for page to be loaded
        wait.until(ExpectedConditions
            .visibilityOf(loginPage.btnEmailSignIn));

        // Login using email address
        loginPage.btnEmailSignIn.click();
        loginPage.emailLogin("aby_azid@yahoo.com", "ZAQ!2wsx");

        // Validate user land on home screen
        try {
            wait.until(ExpectedConditions
                    .visibilityOf(homePage.btnSideMenu));
        }catch (Exception e) {
            Assert.fail("Side menu not visible.Unable to load home/dashboard page ");
        }
    }

    /**
     *  Test “Create Task via mobile phone”
     *  Create test task via mobile application in test project.
     *  API: Verify that task created correctly.
     */
    @Test (dependsOnMethods = {"userLogin"})
    public void createNewProject() {
        // Tap side menu
        homePage.btnSideMenu.click();

        // Create new Project
        homePage.addNewProject();
    }
}
