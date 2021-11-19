package com.selevn.demo.utils;

public class TypeParser {
    public static int parse(String type){
        if(type.equals("RECIPE"))
            return 0;
        if(type.equals("COOKBOOK"))
            return 1;
        return -1;
    }
}
