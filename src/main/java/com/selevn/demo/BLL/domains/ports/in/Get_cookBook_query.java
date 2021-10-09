package com.selevn.demo.BLL.domains.ports.in;

import com.selevn.demo.BLL.domains.entities.CookBook;

import java.util.ArrayList;

public interface Get_cookBook_query {
    public CookBook get_cookBook_query(Integer id);
    public ArrayList<CookBook> get_all_cookBooks_query();
}
