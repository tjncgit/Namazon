package com.Product;

public class Product {
    private String name;
    private ProductCategory category;
    private Double price;
    private int amount;

    public Product(String name, ProductCategory category, Double price){
        this.name = name;
        this.category = category;
        this.price = price;
        this.amount = 1;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //Name
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Category
    public ProductCategory getCategory(){
        return this.category;
    }
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    //Price
    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Category: %s, Price: $%.2f", name, category.name, price);
    }
}
