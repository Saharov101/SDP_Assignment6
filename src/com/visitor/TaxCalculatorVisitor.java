package com.visitor;

public class TaxCalculatorVisitor implements MenuVisitor {
    @Override
    public void visitBeverage(BeverageItem beverage) {
        double tax = beverage.getPrice() * 0.12;
        System.out.printf("%s (Beverage) -> Price: $%.2f | Tax: $%.2f%n",
                beverage.getName(), beverage.getPrice(), tax);
    }

    @Override
    public void visitPastry(PastryItem pastry) {
        double tax = pastry.getPrice() * 0.08;
        System.out.printf("%s (Pastry) -> Price: $%.2f | Tax: $%.2f%n",
                pastry.getName(), pastry.getPrice(), tax);
    }
}