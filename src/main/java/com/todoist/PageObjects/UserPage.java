package com.todoist.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    private AndroidDriver<AndroidElement> driver;

    public UserPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Change the current view']")
    public AndroidElement btnSideMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Projects']")
    public AndroidElement btnProject;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add project']")
    public AndroidElement btnAddProject;

    /*
     This function is for add new project
     */
    public void createNewProjectPage() {
        btnProject.click();
        try {
            btnAddProject.click();
        }catch (Exception e) {
            /*
             If Add project button not visible,
             expand project menu again
             */
            btnProject.click();
            btnAddProject.click();
        }
    }
}
