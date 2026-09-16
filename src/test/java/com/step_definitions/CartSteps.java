package com.step_definitions;

import com.page.AddToCartModal;
import com.page.Cart;
import com.page.ProductsPage;
import com.structure.ProductDTO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps {
    private ProductDTO expected;

    @When("the user click buy some product")
    public void the_user_click_buy_some_product() {
        expected = new ProductsPage().getRandomProduct();
        new ProductsPage().addProductToCart(expected);
    }

    @Then("the product is in the cart")
    public void the_product_is_in_the_cart() {
        AddToCartModal modal = new AddToCartModal();
        if (modal.isModalOpened()){
            modal.openCart();
        }
        ProductDTO actual = new Cart().getProduct().getFirst();

        Assert.assertEquals(actual, expected);
    }

    @When("the user opens cart")
    public void the_user_opens_cart() {
        AddToCartModal modal = new AddToCartModal();
        if (modal.isModalOpened()){
            modal.openCart();
        }
    }


    @When("the user remove product from cart")
    public void the_user_remove_product_from_cart() {
        new Cart().removeProducts();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        int newProductNumber = new Cart().getProduct().size();
        Assert.assertEquals(newProductNumber, 0);
    }
}
