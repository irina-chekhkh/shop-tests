package com.page;

import com.driver.element.SmartElement;
import com.structure.ProductDTO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class ProductCard extends BasePage {
    private final WebElement element;

    public ProductCard(WebElement element) {
        this.element = element;
    }

    private String getName() {
        return new SmartElement(
                element.findElement(By.xpath(".//a[@class='product-card__title']")),
                wait).getText();
    }

    private BigDecimal getPrice() {
        String priceWithoutCorrection = new SmartElement(
                element.findElement(
                        By.xpath(".//div[contains(@class,'cur')]//span[@class='sum']")),
                wait).getText();
        String price = priceWithoutCorrection.replaceAll("[\\s\\u00A0]", "");
        return new BigDecimal(price);
    }

    @Step("Get product details")
    public ProductDTO getProductDetails() {
        return new ProductDTO(getName(), getPrice());
    }
}
