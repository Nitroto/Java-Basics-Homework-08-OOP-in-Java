package com.softuni.oneLevShop.products.electonicsProducts;

import com.softuni.oneLevShop.products.AgeRestriction;
import com.softuni.oneLevShop.products.Product;

public abstract class ElectonicsProduct extends Product {

    private int guaranteePeriod;

    protected ElectonicsProduct(String name, double price, int quantity, AgeRestriction ageRestrictions) {
        super(name, price, quantity, ageRestrictions);
        this.guaranteePeriod = guaranteePeriod;
    }

    public int getGuaranteePeriod() {
        return this.guaranteePeriod;
    }

    protected void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }
}
