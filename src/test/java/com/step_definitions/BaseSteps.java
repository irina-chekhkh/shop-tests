package com.step_definitions;

import com.driver.SingletonDriver;
import com.page.MainPage;
import com.structure.Categories;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

public class BaseSteps {

    @Given("the user opens shop's main page in {string}")
    public void theUserOpensShopMainPage(String browser) {
        SingletonDriver.getInstance(browser.replaceAll("\"",""));
        new MainPage();
    }

    @Given("the user opens {category} products")
    public void the_user_opens_products(Categories category) {
        System.out.println(category);
        new MainPage().openNavigation().openCategory(category);
    }

    @After
    public void closeBrowser() {
        SingletonDriver.closeDriver();
    }
}
