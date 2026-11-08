package com.visitor;

public class CalorieCounterVisitor implements MenuVisitor {
    @Override
    public void visitBeverage(BeverageItem beverage) {
        int calories = (beverage.getVolumeMl() / 2) + (beverage.hasSyrup() ? 80 : 0);
        System.out.println(beverage.getName() + " (Beverage) -> Calories: " + calories + " kcal");
    }

    @Override
    public void visitPastry(PastryItem pastry) {
        int calories = pastry.getWeightGrams() * 4;
        System.out.println(pastry.getName() + " (Pastry) -> Calories: " + calories + " kcal");
    }
}