package com.selevn.demo.utils;

public class HideMyParser {
    public static int parse(String input){
        if(input.equals("false"))
            return -1;
        else
            return Integer.parseInt(input);
    }
}
