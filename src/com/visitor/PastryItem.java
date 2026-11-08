package com.visitor;

public class PastryItem implements MenuItem {
    private final String name;
    private final double price;
    private final int weightGrams;

    public PastryItem(String name, double price, int weightGrams) {
        this.name = name;
        this.price = price;
        this.weightGrams = weightGrams;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getWeightGrams() { return weightGrams; }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visitPastry(this); // Double dispatch
    }
}