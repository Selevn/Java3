package com.selevn.demo.BLL.domains.ports.out.db.loaders;

import com.selevn.demo.BLL.domains.entities.CookBook;

import java.util.ArrayList;

public interface Load_cookBook_port {
    public CookBook load_cookBook(Integer id);
    public ArrayList<CookBook> load_cookBooks();
}
