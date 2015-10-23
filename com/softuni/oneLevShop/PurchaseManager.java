package com.softuni.oneLevShop;

import com.softuni.oneLevShop.interfaces.Expirable;
import com.softuni.oneLevShop.products.AgeRestriction;
import com.softuni.oneLevShop.products.Product;

import java.time.LocalDate;

public final class PurchaseManager {

    private static final int TEENAGE = 13;
    private static final int ADULT = 18;

    private PurchaseManager() {
    }

    public static void processPurchase(Customer customer, Product product) throws Exception {
        if (product.getQuantity() <= 0) {
            throw new Exception("Out of stock!");
        }
        if (product instanceof Expirable) {
            if (((Expirable) product).getExpirationDate() != null) {
                if (((Expirable) product).getExpirationDate().isBefore(LocalDate.now())) {
                    throw new Exception("The shelf life has expired!");
                }
            }
        }
        if (!havePermissions(customer.getAge(), product.getAgeRestrictions())) {
            throw new Exception("You are too young to buy this product!");
        }
        if (customer.getBalance() < product.getPrice()) {
            throw new Exception("You do not have enough money to buy this product!");
        }
        customer.buyProduct(product.getPrice());
        product.setQuantity(product.getQuantity() - 1);
    }

    private static boolean havePermissions(int age, AgeRestriction restrictions) {
        if (restrictions == AgeRestriction.None) {
            return true;
        }
        if (restrictions == AgeRestriction.Teenager && age >= TEENAGE) {
            return true;
        }
        if (restrictions == AgeRestriction.Adult && age >= ADULT) {
            return true;
        }
        return false;
    }
}
