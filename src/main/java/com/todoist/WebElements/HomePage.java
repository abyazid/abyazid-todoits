package com.todoist.WebElements;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private AndroidDriver<AndroidElement> driver;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(linkText = "Get Started – It’s Free")
    public AndroidElement getStartedBtn;

    @FindBy(id = "full_name")
    public AndroidElement txtFullName;

    @FindBy(id = "email")
    public AndroidElement txtEmail;
}
