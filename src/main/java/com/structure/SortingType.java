package com.structure;

public enum SortingType {
    PRICE_ASC("price:asc", "dir-asc/order-price/"),
    PRICE_DESC("price:desc", "dir-desc/order-price/"),
    NAME_ASC("name:asc", "dir-asc/order-name/");

    private final String value;
    private final String url;

    SortingType(String value, String url) {
        this.value = value;
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public String getUrl() {
        return url;
    }
}