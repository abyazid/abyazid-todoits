package com.todoist.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    static int TIMEOUT = 20;

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, TIMEOUT);
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
        try {
            wait.until(ExpectedConditions
                .visibilityOf(txtEmailExistInput));
            txtEmailExistInput.sendKeys(email);
            btnContinueWithEmail.click();
        }catch (Exception e) {
            Assert.fail("Fail to login using email address");
        }

        // Enter password
        try {
            wait.until(ExpectedConditions
                .visibilityOf(txtLogInPassword));
            txtLogInPassword.sendKeys(password);
        }catch (Exception e) {
            Assert.fail("Fail to enter password");
        }

        btnLogIn.click();
    }
}
