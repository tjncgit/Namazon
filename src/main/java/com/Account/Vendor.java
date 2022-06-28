package com.Account;

import com.Exceptions.ProductNotAvailableException;
import com.Order.Address;
import com.Order.Order;
import com.Order.OrderStatus;
import com.Product.Product;
import com.Product.ProductCategory;

import java.util.*;

public class Vendor  extends Account{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String brandName;
    private Map<String, Product> inventory;
    private Product[] showCase;
    private List<Order> orders;

    public Vendor(String brandName, String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.brandName = brandName;
        this.inventory = new HashMap<>();
        this.showCase = new Product[5];
        this.orders = new ArrayList<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Map<String, Product> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Product> inventory) {
        this.inventory = inventory;
    }

    public Product[] getShowCase() {
        return showCase;
    }

    public void setShowCase(Product[] showCase) {
        this.showCase = showCase;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addProduct(Product product) {
        String key = product.getName();
        if (inventory.containsKey(key)) {
            int count = inventory.get(key).getAmount() + 1;
            inventory.get(key).setAmount(count);
        } else {
            inventory.put(key, product);
        }
    }

    public boolean modifyProduct(String productName, String newName) {
        Product mod = getProductFromInventory(productName);
        mod.setName(newName);
        if(mod.getName() != productName ) {
            inventory.put(newName, mod);
            inventory.remove(productName);
            return true;
        }
        return false;
    }

    public  boolean removeProduct(String productName) {
        inventory.remove(productName);
        if(inventory.containsKey(productName)) {
            return false;
        }
        return true;
    }

    public void addProductToShowcase(String productName, Integer index) {
        if (inventory.containsKey(productName)){
            showCase[index] = inventory.get(productName);
        } else {
            System.out.println("Item not in inventory cannot add to showcase");
        }
    }

    public List<Product> searchByCategory(ProductCategory productCategory) {
        List<Product> categoryList = new ArrayList<>();
        for(Product product: getShowCase()){
            if(product == null) {
                continue;
            } else if (product.getCategory() == productCategory) {
                    categoryList.add(product);
            }
        }
        return categoryList;
    }

    public List<Product> searchByName(String productName) {
        List<Product> categoryList = new ArrayList<>();
        for(Product product: getShowCase()){
            if(product == null) {
                continue;
            } else if (product.getName() == productName) {
                categoryList.add(product);
            }
        }
        return categoryList;
    }

    public Product purchase(Product product, Address address) throws ProductNotAvailableException {
        if(product == null) throw new ProductNotAvailableException("Product is not Available");
        product.setAmount(product.getAmount() - 1);
        Order order = new Order(product,address, OrderStatus.PENDING);
        orders.add(order);
        return product;
    }

    public Boolean cancelOrder(String orderName) {
        for(int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            Product product = order.getProduct();
            if(order.getStatus() == OrderStatus.PENDING && product.getName() == orderName) {
                product.setAmount(product.getAmount() + 1);
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    public String displayAllOrders() {
        String allOrders = "";
        for (Order order: getOrders()) {
            allOrders += order.toString() + "\n";
        }
        return allOrders;
    }

    public Product createProduct(String name, ProductCategory category, Double price) {
        return new Product(name, category, price);
    }

    public Product getProductFromInventory(String productName) {
        return inventory.get(productName);
    }

    public Address setNewAddress(String street, String unit, String city, String state ){
        return new Address(street, unit, city, state);
    }

    @Override
    public String toString() {
        return  brandName  + " " + getFirstName() + " " + getLastName() + " " + getEmail() + " " + getPassword() + " " + inventory + " " + Arrays.toString(showCase) + " " + orders;
    }
}
