package com.visitor;

public interface MenuVisitor {
    void visitBeverage(BeverageItem beverage);
    void visitPastry(PastryItem pastry);
}