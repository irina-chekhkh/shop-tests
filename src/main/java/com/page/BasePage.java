package com.page;

import com.constants.LoadConstant;
import com.driver.SingletonDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final Logger logger = LogManager.getLogger(getClass());
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage() {
        driver = SingletonDriver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(LoadConstant.MAX_LOAD_TIME));
        PageFactory.initElements(driver, this);
    }
}
