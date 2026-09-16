package com.structure;

import java.util.Comparator;

public enum SortingType {
    PRICE_ASC("price:asc", "dir-asc/order-price/",
            Comparator.comparing(ProductDTO::price)),
    PRICE_DESC("price:desc", "dir-desc/order-price/",
            Comparator.comparing(ProductDTO::price).reversed()),
    NAME_ASC("name:asc", "dir-asc/order-name/",
            Comparator.comparing(ProductDTO::name));

    private final String value;
    private final String url;
    private final Comparator<ProductDTO> comparator;

    SortingType(String value, String url, Comparator<ProductDTO> comparator) {
        this.value = value;
        this.url = url;
        this.comparator = comparator;
    }

    public Comparator<ProductDTO> getComparator() {
        return comparator;
    }

    public String getValue() {
        return value;
    }

    public String getUrl() {
        return url;
    }
}