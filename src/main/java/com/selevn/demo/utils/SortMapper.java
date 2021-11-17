package com.selevn.demo.utils;

public class SortMapper {
    public static int sortParse(String inputSort){
        if(inputSort.equals("mostPopular"))
            return 1;
        if(inputSort.equals("newest"))
            return 2;
        if(inputSort.equals("mostLiked"))
            return 3;
        if(inputSort.equals("ourchoise"))
            return 3;
        return 0;
    }
}
