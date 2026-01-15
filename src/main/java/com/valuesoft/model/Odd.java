package com.valuesoft.model;

public class Odd {
    private final String side;
    private final double price;

    public Odd(String side, double price) {
        this.side = side;
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public double getPrice() {
        return price;
    }
}
