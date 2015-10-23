package com.softuni.oneLevShop;

public class Customer {

    private String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        this.setName(name);
        this.setBalance(balance);
        this.setAge(age);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void buyProduct(double price) {
        this.setBalance(this.getBalance() - price);
    }
}
