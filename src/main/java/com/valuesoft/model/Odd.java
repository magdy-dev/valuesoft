package com.valuesoft.model;

/**
 * Represents a betting odd for a side/team.
 */
public class Odd {
    private final String side;
    private final double price;

    public Odd(String side, double price) {
        this.side = side;
        this.price = price;
    }

    /**
     * @return the side/team name
     */
    public String getSide() {
        return side;
    }

    /**
     * @return the price/odd value
     */
    public double getPrice() {
        return price;
    }
}
