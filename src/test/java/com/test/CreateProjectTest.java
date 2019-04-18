package com.test;

import com.todoist.PageObjects.ProjectPage;
import com.todoist.PageObjects.TaskPage;
import com.todoist.PageObjects.UserPage;
import com.todoist.PageObjects.LoginPage;
import com.todoist.capabilities.androidCap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.is;

public class CreateProjectTest extends androidCap {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    private static int TIMEOUT = 15;

    // Page object class
    LoginPage loginPage;
    UserPage userPage;
    ProjectPage projectPage;
    TaskPage taskPage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = MobileCapabilities();
        wait = new WebDriverWait(driver, TIMEOUT);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        projectPage = new ProjectPage(driver);
        taskPage = new TaskPage(driver);

        // Login to Mobile App
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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test data for create new project
     * @return
     */
    @DataProvider(name = "Create Project")
    public static Object[][] newProjectDetails() {
        return new Object[][] {{"Project Technical Test"}, {"My Daily Task"}};
    }

    /**
     * This is a test data for creating simple task
     * @return
     */
    @DataProvider(name = "Simple Task")
    public static Object[][] addSimpleTask() {
        return new Object[][] {{"Project Technical Test", "My Simple Task"}, {"My Daily Task", "Morning Task"}};
    }

    /**
     *  1. Login to Mobile App
     *  2. Create new project
     *  3. Verify on monile that project is created
     * @param projectName
     */
    @Test(dataProvider = "Create Project", priority = 0)
    public void createNewProject(String projectName) {

        // Tap side menu
        userPage.btnSideMenu.click();

        // Create new Project
        userPage.createNewProjectPage();

        // Enter new project details
        projectPage.txtProjectName.sendKeys(projectName);
        projectPage.tickBoxFavourite.click();
        projectPage.submitNewProject.click();

        /*
         Verify that project was successfully created
         */
        wait.until(ExpectedConditions
            .visibilityOf(userPage.btnSideMenu));
        //String projectName = "Project Aby Azid";
        Assert.assertThat(driver.findElementByXPath("//android.widget.TextView[@text='"+projectName+"']").isDisplayed(), is(true));

    }

    /**
     *  1. Login to Mobile App
     *  2. Select existing project
     *  3. Create new task
     *  4. Verify task created correctly
     * @param projectName
     */
    @Test(dataProvider = "Simple Task", priority = 1)
    public void createNewSimpleTask(String projectName, String taskName) {

        // Debug
        System.out.println("Project Name: " + projectName + " Task Name: " + taskName);

        // Tap side menu
        userPage.btnSideMenu.click();

        // Expand Project
        wait.until(ExpectedConditions
            .elementToBeClickable(userPage.btnProject));
        userPage.btnProject.click();

        // Search and select existing project
        try {
            projectPage.selectProject(projectName);
        } catch (Exception e) {
            Assert.fail("Project Name not found");
        }

        // Add new task
        projectPage.addNewTask.click();
        taskPage.addSimpleTask(taskName);
    }

    @Test(dataProvider = "Simple Task", priority = 2)
    public void createReopenTask(String projectName, String taskName) {
        // Tap side menu
        userPage.btnSideMenu.click();

        // Expand Project
        wait.until(ExpectedConditions
                .elementToBeClickable(userPage.btnProject));
        userPage.btnProject.click();

        // Search and select existing project
        try {
            projectPage.selectProject(projectName);
        } catch (Exception e) {
            Assert.fail("Project Name not found");
        }

    }

}
