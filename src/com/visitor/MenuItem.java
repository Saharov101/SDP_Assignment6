package com.visitor;

public interface MenuItem {
    void accept(MenuVisitor visitor);
}