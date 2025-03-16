package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.time.Duration;

public class DriverManager {
        static AndroidDriver driver;

            public static void createDriver() {

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
                capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
                capabilities.setCapability("app", System.getProperty("user.dir") + ConfigReader.getConfigValue("app.path"));
                capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
                capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
                capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
//                capabilities.setCapability("noReset",true);
                driver = new AndroidDriver(capabilities);

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            }


            public static AppiumDriver getDriver() {
                return driver;
            }

    public static byte[] takeScreenShotAsBytes() {
        return  ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
