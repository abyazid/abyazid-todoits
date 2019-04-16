package com.todoist.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private AndroidDriver<AndroidElement> driver;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Change the current view']")
    public AndroidElement btnSideMenu;

    public void addNewProject() {
        AndroidElement newProject = driver.findElementByXPath(
          "//android.widget.TextView[@text='Projects']/following::" +
                  "android.widget.TextView[@resource-id='com.todoist:id/add']"
        );
        newProject.click();
    }


}
