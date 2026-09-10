package com.page;

import com.driver.element.SmartElement;
import com.constants.LoadConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AddToCartModal extends BasePage {

    private final By modalContainer = By.xpath("//div[contains(@class,'v-modal__cmp') and contains(@class, 'related-products__modal')]");

    private final By firstLoader = By.xpath("//div[@class='cart-modal loading']");

    private final By secondLoader = By.xpath("//div[contains(@class,'is-loading')]");

    private final By openCartButton = By.xpath("//button[contains(@class,'a-button--outline')]");


    public boolean isModalOpened() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(firstLoader));
            wait.withTimeout(Duration.ofMillis(LoadConstant.MIN_LOAD_TIME))
                    .until(ExpectedConditions.visibilityOfElementLocated(modalContainer));
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(secondLoader));
            } catch (Exception ignored) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Cart openCart() {
        logger.info("Clicking 'Open Cart' inside modal");
        new SmartElement(openCartButton, wait).click();
        return new Cart();
    }

}
