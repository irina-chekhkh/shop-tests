package com.step_definitions;

import com.page.ProductsPage;
import com.structure.ProductDTO;
import com.structure.SortingType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class SortingSteps {
    SortingType sortingType;

    @When("the user sorts products by {sort_type}")
    public void the_user_sorts_products_by(SortingType sortingType) {
        this.sortingType = sortingType;
        new ProductsPage().changeSorting(this.sortingType);
    }

    @Then("the products should be sorted correctly")
    public void the_products_should_be_sorted_correctly() {
        List<ProductDTO> actualList = new ProductsPage().getProductCards();

        List<ProductDTO> expectedList = actualList
                .stream()
                .sorted(sortingType.getComparator())
                .toList();
        Assert.assertEquals(expectedList, actualList);
    }
}
