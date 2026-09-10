package com.page;


import com.utils.BrowserActions;
import com.driver.element.SmartElement;
import com.structure.Categories;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Navigation extends BasePage {
    public Navigation() {
        super();
    }

    private void hoverCategory(String path) {
        BrowserActions.hover(driver, wait, By.xpath(path));
    }

    private void choseCategory(String path) {
        SmartElement smartElement = new SmartElement(By.xpath(path), wait);
        smartElement.click();
    }

    public void choseSubCategory(String path) {
        BrowserActions.scroll(driver, wait, By.xpath(path));
        new SmartElement(By.xpath(path), wait)
                .click();
    }

    @Step("Open category")
    public ProductsPage openCategory(Categories category) {
        logger.info("Opening category {}", category);
        if (category.getParent() == null) {
            choseCategory(category.getPath());
        } else {
            hoverCategory(category.getParent().getPath());
            choseSubCategory(category.getPath());
        }
        return new ProductsPage();
    }


}
