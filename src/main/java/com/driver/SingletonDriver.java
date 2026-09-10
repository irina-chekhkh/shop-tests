package com.driver;

import org.openqa.selenium.WebDriver;

public class SingletonDriver {
    private static SingletonDriver instance;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private SingletonDriver() {
    }

    public static SingletonDriver getInstance(String browser) {
        if (instance == null) {
            instance = new SingletonDriver();
        }
        if (driver.get() == null) {
            driver.set(DriverFactory.createDriver(browser));
            driver.get().manage().window().maximize();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
