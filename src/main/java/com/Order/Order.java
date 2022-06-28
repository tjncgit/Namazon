package com.Order;

import com.Product.Product;

public class Order {
    private Long id;
    private Product product;
    private Address destination;
    private OrderStatus status;

    public Order(Product product, Address destination, OrderStatus status){
        this.product = product;
        this.destination = destination;
        this.status = status;
    }
    //Product
    public Product getProduct(){
        return this.product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    //Address
    public Address getDestination(){
        return this.destination;
    }
    public void setDestination(){
        this.destination = destination;
    }
    //OrderStatus
    public OrderStatus getStatus(){
        return this.status;
    }
    public void setStatus(){
        this.status = status;
    }
    @Override
    public String toString(){
        return String.format("Product: %s, Address: %s, Status: %s", product, destination, status.name);
    }
}
