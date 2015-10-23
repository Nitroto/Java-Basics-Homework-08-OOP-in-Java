package com.softuni.oneLevShop.products.electonicsProducts;

import com.softuni.oneLevShop.products.AgeRestriction;

public class Appliance extends ElectonicsProduct {

    public Appliance(String name, double price, int quantity, AgeRestriction ageRestrictions) {
        super(name, price, quantity, ageRestrictions);
        this.setGuaranteePeriod(6);
    }

    @Override
    public double getPrice() {
        if (this.getQuantity() < 50) {
            return (this.getPrice() * 1.05);
        }
        return this.getPrice();
    }
}
