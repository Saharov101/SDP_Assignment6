package com.visitor;

public class BeverageItem implements MenuItem {
    private final String name;
    private final double price;
    private final int volumeMl;
    private final boolean hasSyrup;

    public BeverageItem(String name, double price, int volumeMl, boolean hasSyrup) {
        this.name = name;
        this.price = price;
        this.volumeMl = volumeMl;
        this.hasSyrup = hasSyrup;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getVolumeMl() { return volumeMl; }
    public boolean hasSyrup() { return hasSyrup; }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visitBeverage(this);
    }
}