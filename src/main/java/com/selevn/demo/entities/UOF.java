package com.selevn.demo.entities;


import com.selevn.demo.entities.countEntities.CookBooksOutWrapper;
import com.selevn.demo.entities.repositories.CookBooksRepository;
import com.selevn.demo.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UOF {
    @Autowired
    private CookBooksRepository repository;

    public CookBooksOutWrapper getCookBooks(Integer page,
                                            Integer sortby,
                                            Boolean vegeterian,
                                            Boolean noMilk,
                                            Boolean noEggs,
                                            Integer hidemy,
                                            String searchString) {
        CookBooksOutWrapper books = new CookBooksOutWrapper();
        if(page == null)
            page = 0;
        if(sortby == null)
            sortby = 0;
        if(hidemy == null)
            hidemy = -1;

        if(searchString == null)
            searchString = "";

        StringBuilder filters = new StringBuilder();

        filters.append('b');

        if(vegeterian == null || vegeterian == false)
            filters.append(0);
        else
            filters.append(1);
        if(noMilk == null || noMilk == false)
            filters.append(0);
        else
            filters.append(1);
        if(noEggs == null || noEggs == false)
            filters.append(0);
        else
            filters.append(1);
        if(filters.toString().equals("b000")) {
            books.docs = repository.getAllNoFilters(15, page, sortby, hidemy, searchString);
            books.total = repository.getAllNoFiltersCount(15, page, sortby, hidemy, searchString);
        }
        else {
            books.total =repository.getAllCount(15, page, sortby, filters.toString(), hidemy, searchString);
            books.docs = repository.getAll(15, page, sortby, filters.toString(), hidemy, searchString);
        }
        books.hasNext = Pager.hasNext(page,books.total);
        books.nextPage = page+2;
        return books;
    }
    public CookBooksOutWrapper getCookBooks() {
        return this.getCookBooks(0,0, null,null,null, -1, "");
    }
}
