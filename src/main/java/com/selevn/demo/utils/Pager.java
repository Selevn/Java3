package com.selevn.demo.utils;

public class Pager {
    public static boolean hasNext(int currentPage, int collectionLength){
        return (currentPage+1)*15 <= collectionLength;
    }
}
