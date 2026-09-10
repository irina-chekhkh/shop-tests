package com.page;

import com.driver.element.SmartElement;
import com.constants.LoadConstant;
import com.structure.ProductDTO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart extends BasePage {
    private final By modal = By.xpath("//div[contains(@class,'v-modal__wrapper')]");
    private final By loadingOverlay = By.xpath("//div[contains(@class,'loading')]");


    public Cart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modal));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
        } catch (Exception ignored) {
        }
    }

    @Step("Get products from the cart")
    public List<ProductDTO> getProduct() {
        logger.info("Get Products from cart");
        List<ProductDTO> products = new ArrayList<>();

        List<WebElement> currentItems;
        try {
            currentItems = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[contains(@class,'product-item')]"))
            );
        } catch (Exception ignored) {
            logger.info("Don't get products from cart");
            currentItems = new ArrayList<>();
        }

        for (WebElement item : currentItems) {
            String name = new SmartElement(
                    item.findElement(By.xpath(".//div[@class='title']//a")), wait
            ).getText();

            String price = new SmartElement(
                    item.findElement(By.xpath(".//div[contains(@class,'price-box__cur')]")), wait
            ).getText();
            price = price.replaceAll("\\D", "");
            products.add(new ProductDTO(name, new BigDecimal(price)));
        }
        return products;
    }

    @Step("Remove products from the cart")
    public Cart removeProducts() {
        logger.info("Removing all products from cart by targeting the SVG element directly");

        By removeButton = By.xpath("//*[contains(@class,'remove')]");

        while (true) {
            List<WebElement> removeItems = driver.findElements(removeButton);

            if (removeItems.isEmpty()) {
                break;
            }

            try {
                WebElement svgElement = removeItems.get(0);
                org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles: true}));", svgElement);

                Thread.sleep(LoadConstant.MIN_LOAD_TIME);
            } catch (Exception e) {
                logger.error("Error during product removal: " + e.getMessage());
                break;
            }
        }

        return this;
    }
}
