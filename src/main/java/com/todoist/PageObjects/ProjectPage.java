package com.todoist.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

    private AndroidDriver<AndroidElement> driver;

    public ProjectPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/name\")")
    public AndroidElement txtProjectName;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"\")")
    public AndroidElement colorPicker;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/parent\")")
    public AndroidElement txtBoxParent;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/collaborators\")")
    public AndroidElement txtBoxCollaborators;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/favorite\")")
    public AndroidElement tickBoxFavourite;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/menu_form_submit\")")
    public AndroidElement submitNewProject;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/fab\")")
    public AndroidElement addNewTask;

    public void selectColorPicker(String color) {
        colorPicker.click();
    }

    public void selectProject(String name) {
        //driver.findElement(By.xpath(“//android.widget.Button[contains(@resource-id,’digit5′) and @text=’5′]”));
        AndroidElement projectName = driver.findElementByXPath(
                "//android.widget.TextView[contains(@resource-id, 'com.todoist:id/name') and @text='"+name+"']"
        );
        projectName.click();
    }
}
