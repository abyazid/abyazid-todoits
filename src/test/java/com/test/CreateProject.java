package com.test;

import com.todoist.PageObjects.AddProjectPage;
import com.todoist.PageObjects.UserPage;
import com.todoist.PageObjects.LoginPage;
import com.todoist.capabilities.androidCap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.is;

public class CreateProject extends androidCap {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    private static int TIMEOUT = 15;

    // Page object class
    LoginPage loginPage;
    UserPage userPage;
    AddProjectPage addProjectPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = MobileCapabilities();
        wait = new WebDriverWait(driver, TIMEOUT);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        addProjectPage = new AddProjectPage(driver);
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
                    .visibilityOf(userPage.btnSideMenu));
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
        userPage.btnSideMenu.click();

        // Create new Project
        userPage.createNewProjectPage();

        // Enter new project details
        addProjectPage.txtProjectName.sendKeys("Project Aby Azid");
        addProjectPage.tickBoxFavourite.click();
        addProjectPage.submitNewProject.click();

        /*
         Verify that project was successfully created
         */
        wait.until(ExpectedConditions
            .visibilityOf(userPage.btnSideMenu));
        String projectName = "Project Aby Azid";
        Assert.assertThat(driver.findElementByXPath("//android.widget.TextView[@text='"+projectName+"']").isDisplayed(), is(true));

    }
}
