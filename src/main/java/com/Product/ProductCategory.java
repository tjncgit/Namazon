package com.Product;

public enum ProductCategory {
    ELECTRONICS("Electronics"), ATHLETICS("Athletics"), CLOTHING("Clothing"),HOME_APPLIANCES("Home Appliances");

    public final String name;

    ProductCategory(String name) {
        this.name = name;
    }
}
