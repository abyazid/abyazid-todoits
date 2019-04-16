package com.todoist.capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class androidCap {


    public static AndroidDriver<AndroidElement> MobileCapabilities() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver;

        File appDir = new File("src/test/resources");
        File app = new File(appDir, "Todoist_v12.8_apkpure.com.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AGS_W09");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        capabilities.setCapability("appPackage", "com.todoist");
        capabilities.setCapability("appWaitActivity", "");
        //capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "40");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        //capabilities.setCapability("unicodeKeyboard", true);
        //capabilities.setCapability("resetKeyboard", true);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;
    }

}
