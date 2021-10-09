package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.entities.CookBook;
import com.selevn.demo.BLL.domains.ports.in.Get_cookBook_query;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_cookBook_port;

import java.util.ArrayList;

public class Get_cookBook_service implements Get_cookBook_query {
    private Load_cookBook_port _loadCookBookPort;

    public Get_cookBook_service(Load_cookBook_port _loadCookBookPort) {
        this._loadCookBookPort = _loadCookBookPort;
    }

    @Override
    public CookBook get_cookBook_query(Integer id) {
        return _loadCookBookPort.load_cookBook(id);
    }

    @Override
    public ArrayList<CookBook> get_all_cookBooks_query() {
        return _loadCookBookPort.load_cookBooks();
    }
}
