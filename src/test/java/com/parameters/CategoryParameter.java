package com.parameters;

import com.structure.Categories;
import io.cucumber.java.ParameterType;

public class CategoryParameter {
    @ParameterType(".*")
    public Categories category(String category) {
        category = category.toLowerCase()
                .replaceAll("[_\"]", "");
        for (Categories c : Categories.values()) {
            if (c.name().toLowerCase().equals(category)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Category " + category + " not found");
    }
}
