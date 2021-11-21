package com.selevn.demo.utils;

public enum ItemType {
    RECIPE(0), COOKBOOK(1);

    private int numVal;

    ItemType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
