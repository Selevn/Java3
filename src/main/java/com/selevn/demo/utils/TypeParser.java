package com.selevn.demo.utils;

public class TypeParser {
    public static int parse(String type){
        if(type == "RECIPE")
            return 0;
        if(type == "COOKBOOK")
            return 1;
        return -1;
    }
}
