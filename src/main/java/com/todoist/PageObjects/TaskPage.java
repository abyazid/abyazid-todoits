package com.todoist.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskPage {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    private static int TIMEOUT = 15;

    public TaskPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/fab\")")
    public AndroidElement btnSubmitTask;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
    public AndroidElement txtTaskName;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/content\")")
    public AndroidElement txtMainTaskName;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    public AndroidElement btnMoreOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/due_date\")")
    public AndroidElement btnDueDate;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/scheduler_tomorrow\")")
    public AndroidElement btnDueDateTomorrow;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/priority\")")
    public AndroidElement btnPriority;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/labels\")")
    public AndroidElement btnLabels;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/parent\")")
    public AndroidElement btnParent;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/comments\")")
    public AndroidElement btnComments;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    public AndroidElement androidBtnOne;

    public void addSimpleTask(String simpleTaskName) {

        // Enter task name
        txtTaskName.sendKeys(simpleTaskName);

        // Submit new task
        androidBtnOne.click();

        // Tap button 1 to clear the keyboard
        androidBtnOne.click();
    }

    public void addNewTask() {
        // Enter task name
        txtMainTaskName.sendKeys("");

        /*
         Select due date as tomorrow
         */
        btnDueDate.click();
        btnDueDateTomorrow.click();

        // Submit new task
        btnSubmitTask.click();
    }

    public void selectTask(String taskName) {
        // Find task and click
        driver.findElementByXPath(
                "//android.widget.TextView[contains(@resource-id, 'com.todoist:id/text') and @text='"+taskName+"']"
        ).click();
    }
}
