package com;

import com.structure.ProductDTO;
import com.structure.SortingType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class SortingTests extends BaseTests {

    @Test
    public void sortProductsByNameTest() {
        List<String> actualTitles = openProductsPage()
                .changeSorting(SortingType.NAME_ASC)
                .getProductCards()
                .stream()
                .map(ProductDTO::name)
                .toList();

        List<String> expectedTitles = actualTitles
                .stream()
                .sorted()
                .toList();
        Assert.assertEquals(expectedTitles, actualTitles);
    }

    @Test
    public void sortProductsByPriceAscTest() {
        List<BigDecimal> actualPrices = openProductsPage()
                .changeSorting(SortingType.PRICE_ASC)
                .getProductCards()
                .stream()
                .map(ProductDTO::price)
                .toList();

        List<BigDecimal> expectedPrices = actualPrices
                .stream()
                .sorted()
                .toList();

        Assert.assertEquals(expectedPrices, actualPrices);
    }

    @Test
    public void sortProductsByPriceDescTest() {
        List<BigDecimal> actualPrices = openProductsPage()
                .changeSorting(SortingType.PRICE_DESC)
                .getProductCards()
                .stream()
                .map(ProductDTO::price)
                .toList();

        List<BigDecimal> expectedPrices = actualPrices
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        Assert.assertEquals(expectedPrices, actualPrices);
    }

}
