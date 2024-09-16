package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static AppiumDriver driver;

    public static void createDriver() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
        caps.setCapability("appium:app", ConfigReader.getConfigValue("app.path"));  // The filename of the mobile app
        caps.setCapability("appium:deviceName", ConfigReader.getConfigValue("device.name"));
        caps.setCapability("appium:automationName", ConfigReader.getConfigValue("automation.name"));
        caps.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
        caps.setCapability("appPackage","com.swaglabsmobileapp");

        driver = new AndroidDriver(caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
