package com;

import com.driver.SingletonDriver;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    protected final Logger logger = LogManager.getLogger(getClass());

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            byte[] screenshot = ((TakesScreenshot) SingletonDriver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Screenshot",
                    "image/png",
                    new java.io.ByteArrayInputStream(screenshot),
                    ".png"
            );
        }catch (Exception e){
            logger.error("Can't take screenshot");
        }
    }
}
