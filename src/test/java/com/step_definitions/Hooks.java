package com.step_definitions;

import com.driver.SingletonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @After(order = 1)
    public void takeScreenshort(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                var driver = SingletonDriver.getDriver();
                if (driver != null) {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @After(order = 0)
    public void closeDriver() {
        SingletonDriver.closeDriver();
    }
}
