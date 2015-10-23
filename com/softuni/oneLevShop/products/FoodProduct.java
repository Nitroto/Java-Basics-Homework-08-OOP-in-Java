package com.softuni.oneLevShop.products;

import com.softuni.oneLevShop.interfaces.Expirable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FoodProduct extends Product implements Expirable {

    private LocalDate expirationDate;

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestrictions) {
        super(name, price, quantity, ageRestrictions);
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The shelf life has expired!");
        }
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public double getPrice() {
        if (this.expirationDate != null) {
            long daysToExpiration = ChronoUnit.DAYS.between(LocalDate.now(), this.expirationDate);
            if (daysToExpiration <= 15) {
                return (super.getPrice() * 0.7);
            }
        }

        return super.getPrice();
    }
}
