package com;

import com.page.AddToCartModal;
import com.page.Cart;
import com.page.ProductsPage;
import com.structure.ProductDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTests {
    @Test
    public void addProductToCart() {
        ProductDTO expectedProduct = openProductsPage()
                .getRandomProduct();

        AddToCartModal modal = new ProductsPage()
                .addProductToCart(expectedProduct.name());

        if (modal.isModalOpened()) {
            modal.openCart();
        }

        ProductDTO actualProduct = new Cart().getProduct().get(0);
        Assert.assertEquals(actualProduct, expectedProduct);
    }

    @Test
    public void removeProductFromCart() {
        ProductDTO product = openProductsPage()
                .getRandomProduct();
        AddToCartModal modal = new ProductsPage()
                .addProductToCart(product.name());

        if (modal.isModalOpened()) {
            modal.openCart();
        }

        int newProductNumber = new Cart().removeProducts().getProduct().size();
        Assert.assertEquals(newProductNumber, 0);
    }

}
