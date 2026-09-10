package com.page;

import com.driver.element.SmartElement;
import com.structure.ProductDTO;
import com.structure.SortingType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'toolbar')]//div[contains(@class,'container')]")
    private WebElement sortingContainer;

    @FindBy(xpath = "//div[@class='product-card' and not(.//*[contains(@class,'out-stock')])]")
    private List<WebElement> productList;

    public ProductsPage() {
        super();
    }

    @Step("Change sorting")
    public ProductsPage changeSorting(SortingType sortingType) {
        logger.info("Changing sorting type to {}", sortingType);
        new SmartElement(sortingContainer, wait).click();
        new SmartElement(By.xpath(String.format("//li[@data-value='%s']", sortingType.getValue())), wait)
                .click();

        wait.until(ExpectedConditions.urlContains(sortingType.getUrl()));
        return this;
    }

    @Step("Get product card")
    public List<ProductDTO> getProductCards() {
        logger.info("Getting product cards");
        List<ProductDTO> productCards = new ArrayList<>();
        for (WebElement product : productList) {
            productCards.add(new ProductCard(product).getProductDetails());
        }
        return productCards;
    }

    @Step("Get random product")
    public ProductDTO getRandomProduct() {
        logger.info("Getting random product");

        if (productList.isEmpty()) {
            logger.error("Product list is empty");
            throw new IllegalStateException("There is no product to get");
        }
        int index = new Random().nextInt(productList.size());
        return new ProductCard(productList.get(index)).getProductDetails();
    }

    @Step("Add product to the cart")
    public AddToCartModal addProductToCart(String productName) {
        logger.info("Adding product to cart");
        new SmartElement(By.xpath(
                String.format("//div[@class='product-card' and .//a[@title='%s']]//button[contains(@class,'cart')]", productName.strip())
        ), wait).click();
        return new AddToCartModal();
    }
}
