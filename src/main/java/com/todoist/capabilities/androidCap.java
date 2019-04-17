package com.todoist.capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class androidCap {

    private static AndroidDriver<AndroidElement> driver;


    public static AndroidDriver<AndroidElement> MobileCapabilities() throws MalformedURLException {

        File appDir = new File("src/test/resources");
        File app = new File(appDir, "Todoist_v12.8_apkpure.com.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        capabilities.setCapability("appPackage", "com.todoist");
        //capabilities.setCapability("appWaitActivity", "");
        //capabilities.setCapability(MobileCapabilityType.FULL_RESET, "");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        //capabilities.setCapability("unicodeKeyboard", true);
        //capabilities.setCapability("resetKeyboard", true);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;
    }

    public static AndroidDriver<AndroidElement> ChromeCapabilities() throws MalformedURLException {
        DesiredCapabilities chromeCap = new DesiredCapabilities();
        chromeCap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        chromeCap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), chromeCap);

        return driver;
    }

}
