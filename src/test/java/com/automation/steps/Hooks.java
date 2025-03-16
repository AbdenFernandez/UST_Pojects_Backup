package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

import static com.automation.utils.DriverManager.takeScreenShotAsBytes;

public class Hooks {
    @Before
    public void setUp() {
        ConfigReader.intiConfig();
        DriverManager.createDriver();

    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(takeScreenShotAsBytes(), "image/png", "Failed Executing the following Scenario : " + scenario.getName());
        } else
            scenario.attach(takeScreenShotAsBytes(), "image/png", scenario.getName());
    }

    @After
    public void cleanUp(Scenario scenario) {
        scenario.attach(takeScreenShotAsBytes(), "image/png", "Scenario Execution has been Completed");
        DriverManager.getDriver().quit();
    }



}
