package com.selevn.demo.BLL.domains.modules;

import com.selevn.demo.BLL.domains.entities.CookBook;
import com.selevn.demo.BLL.domains.modules.entities.Repositories.CookBookRepository;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_cookBook_port;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class LoadCookBookAdapter implements Load_cookBook_port {

    @Autowired
    CookBookRepository repository;

    @Override
    public CookBook load_cookBook(Integer id) {
        return null;/*repository.getCookBookBy_id(id);*/
    }

    @Override
    public ArrayList<CookBook> load_cookBooks() {
        return null;
    }
}
