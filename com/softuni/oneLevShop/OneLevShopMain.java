package com.softuni.oneLevShop;

import com.softuni.oneLevShop.interfaces.Expirable;
import com.softuni.oneLevShop.products.AgeRestriction;
import com.softuni.oneLevShop.products.FoodProduct;
import com.softuni.oneLevShop.products.Product;
import com.softuni.oneLevShop.products.electonicsProducts.Appliance;
import com.softuni.oneLevShop.products.electonicsProducts.Computer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class OneLevShopMain {

    public static void main(String[] args) {
        FoodProduct cigars = new FoodProduct("420 Blaze it fgt", 6.90, 1400, AgeRestriction.Adult);
        Customer pecata = new Customer("Pecata", 17, 30.00);
        try {
            PurchaseManager.processPurchase(pecata, cigars);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Customer gopeto = new Customer("Gopeto", 18, 0.44);
        try {
            PurchaseManager.processPurchase(gopeto, cigars);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        cigars.setExpirationDate(LocalDate.of(2026, 06, 16));
        FoodProduct beer = new FoodProduct("Beer", 1, 100000, AgeRestriction.Adult);
        beer.setExpirationDate(LocalDate.of(2016, 02, 20));
        FoodProduct steak = new FoodProduct("Steak", 10, 100, AgeRestriction.None);
        steak.setExpirationDate(LocalDate.of(2015, 10, 26));
        FoodProduct salami = new FoodProduct("Salami", 6.2, 200, AgeRestriction.None);
        salami.setExpirationDate(LocalDate.of(2015, 11, 10));
        FoodProduct energyDrink = new FoodProduct("Energy Drink", 2, 1000, AgeRestriction.Teenager);
        energyDrink.setExpirationDate(LocalDate.of(2020, 12, 31));


        Product[] products = new Product[]{ //(int year, int month, int dayOfMonth) {
                cigars, beer, steak, salami, energyDrink,
                new Computer("Machine", 1000, 999, AgeRestriction.None),
                new Appliance("Keyboard", 20, 2500, AgeRestriction.None)
        };
        Object[] filterdeProducts = Arrays.stream(products)
                .filter(x -> x instanceof Expirable)
                .sorted(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return ((((FoodProduct) o1).getExpirationDate()).compareTo(((FoodProduct) o2).getExpirationDate()));
                    }
                })
                .toArray();
        System.out.println(((Product) filterdeProducts[0]).getName());

        Object[] onlyForAdult = Arrays.stream(products)
                .filter(x -> x.getAgeRestrictions() == AgeRestriction.Adult)
                .sorted(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return ((Double) o1.getPrice()).compareTo((Double) o2.getPrice());
                    }
                })
                .toArray();
        for (Object product : onlyForAdult) {
            System.out.println(((Product) product).getName() + " - " + ((Product) product).getPrice());
        }
    }
}
