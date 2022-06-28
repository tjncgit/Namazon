package com.Order;

public enum OrderStatus {
    PENDING("Pending"),SHIPPED("Shipped"), DELIVERED("Delivered");

    public final String name;

    OrderStatus(String name){
        this.name = name;
    }
}
