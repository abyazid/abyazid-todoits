package com.todoist.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    AndroidDriver<AndroidElement> driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Todoist Logo']")
    public AndroidElement TodoistLogo;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/btn_google\")")
    public AndroidElement btnGoogleSignIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/btn_facebook\")")
    public AndroidElement btnFacebookSignIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/btn_welcome_continue_with_email\")")
    public AndroidElement btnEmailSignIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/email_exists_input\")")
    public AndroidElement txtEmailExistInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/log_in_password\")")
    public AndroidElement txtLogInPassword;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/btn_continue_with_email\")")
    public AndroidElement btnContinueWithEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.todoist:id/btn_log_in\")")
    public AndroidElement btnLogIn;


    /**
     *
     * @param email
     * @param password
     */
    public void emailLogin(String email, String password) {
        // Enter email address
        txtEmailExistInput.sendKeys(email);
        btnContinueWithEmail.click();

        // Enter password
        txtLogInPassword.sendKeys(password);
        btnLogIn.click();
    }
}
