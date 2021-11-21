package com.selevn.demo.entities.wrapper;

import java.util.List;

public class EntityWrapper<T> {
    public List<T> docs;
    public int total;
    public boolean hasNext;
    public int nextPage;
}
