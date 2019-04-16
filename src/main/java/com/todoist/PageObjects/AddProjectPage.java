package com.todoist.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddProjectPage {

    private AndroidDriver<AndroidElement> driver;

    public AddProjectPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/name\")")
    public AndroidElement txtProjectName;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"\")")
    public AndroidElement colorPicker;


    public void selectColorPicker(String color) {
        colorPicker.click();
    }
}
