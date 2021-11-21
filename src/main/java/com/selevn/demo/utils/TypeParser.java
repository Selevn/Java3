package com.selevn.demo.utils;

public class TypeParser {
    public static int parse(String type){
        if(type.equals("RECIPE"))
            return ItemType.RECIPE.getNumVal();
        if(type.equals("COOKBOOK"))
            return ItemType.COOKBOOK.getNumVal();
        return -1;
    }
}
