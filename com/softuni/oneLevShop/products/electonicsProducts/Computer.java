package com.softuni.oneLevShop.products.electonicsProducts;

import com.softuni.oneLevShop.products.AgeRestriction;

public class Computer extends ElectonicsProduct {

    public Computer(String name, double price, int quantity, AgeRestriction ageRestrictions) {
        super(name, price, quantity, ageRestrictions);
        this.setGuaranteePeriod(24);
    }

    @Override
    public double getPrice() {
        if (this.getQuantity() > 1000) {
            return (this.getPrice() * 0.95);
        }
        return this.getPrice();
    }
}
