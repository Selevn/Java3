package com.selevn.demo.entities.countEntities;

import com.selevn.demo.entities.CookbooksViewEntity;

import java.util.List;

public class CookBooksOutWrapper {
    public List<CookbooksViewEntity> docs;
    public int total;
    public boolean hasNext;
    public int nextPage;
}
