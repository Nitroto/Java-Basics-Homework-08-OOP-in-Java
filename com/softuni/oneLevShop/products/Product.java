package com.softuni.oneLevShop.products;

import com.softuni.oneLevShop.interfaces.Bayable;

public class Product implements Bayable {

    private String name;
    private double price;
    private AgeRestriction ageRestrictions;
    private int quantity;

    protected Product(String name, double price, int quantity, AgeRestriction ageRestrictions) {
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.ageRestrictions = ageRestrictions;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name of product can not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("The price of product can not be negative!");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AgeRestriction getAgeRestrictions() {
        return this.ageRestrictions;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
