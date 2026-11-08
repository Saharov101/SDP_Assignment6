package com.visitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> orderItems = List.of(
                new BeverageItem("Caramel Latte", 4.50, 350, true),
                new BeverageItem("Americano", 3.00, 250, false),
                new PastryItem("Almond Croissant", 3.80, 120)
        );

        MenuVisitor calorieVisitor = new CalorieCounterVisitor();
        MenuVisitor taxVisitor = new TaxCalculatorVisitor();

        System.out.println("=== 1. Nutritional Report (CalorieCounterVisitor) ===");
        for (MenuItem item : orderItems) {
            item.accept(calorieVisitor);
        }

        System.out.println("\n=== 2. Accounting Tax Report (TaxCalculatorVisitor) ===");
        for (MenuItem item : orderItems) {
            item.accept(taxVisitor);
        }
    }
}