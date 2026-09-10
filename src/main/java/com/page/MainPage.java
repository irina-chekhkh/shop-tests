package com.page;

import com.driver.element.SmartElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'catalog')]")
    private WebElement catalogButton;

    public MainPage() {
        super();
        logger.info("Open main page");
        driver.get("https://allo.ua/");

    }

    @Step("Open navigation page")
    public Navigation openNavigation() {
        logger.info("Open navigation");
        new SmartElement(catalogButton, wait).click();
        return new Navigation();
    }
}
