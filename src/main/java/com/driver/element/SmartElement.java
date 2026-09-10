package com.driver.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartElement {
    private final WebElement element;
    private final WebDriverWait wait;
    private final By by;

    public SmartElement(WebElement element, WebDriverWait wait) {
        this.element = element;
        this.wait = wait;
        this.by = null;
    }

    public SmartElement(By by, WebDriverWait wait) {
        this.by = by;
        this.wait = wait;
        element = null;
    }

    public WebElement getElement() {
        if (element != null) {
            return element;
        }
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click() {
        WebElement currentElement = getElement();
        wait.until(ExpectedConditions.elementToBeClickable(currentElement)).click();
    }

    public String getText() {
        WebElement currentElement = getElement();
        return currentElement.getText();
    }
}
