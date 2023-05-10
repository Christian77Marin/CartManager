package com.cmarinre.models;

public class Product {
    private int id;
    private String description;
    private int quantity;
    
    public Product(int id, String description, int quantity) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
