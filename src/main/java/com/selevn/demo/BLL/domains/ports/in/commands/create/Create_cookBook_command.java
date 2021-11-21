package com.selevn.demo.BLL.domains.ports.in.commands.create;

import com.selevn.demo.BLL.domains.entities.CookBook;

public class Create_cookBook_command {
    private Integer _userId;
    private CookBook _cookBook;

    public Create_cookBook_command(Integer _userId, CookBook _cookBook) {
        this._userId = _userId;
        this._cookBook = _cookBook;
    }

    public Integer get_userId() {
        return _userId;
    }

    public void set_userId(Integer _userId) {
        this._userId = _userId;
    }

    public CookBook get_cookBook() {
        return _cookBook;
    }

    public void set_cookBook(CookBook _cookBook) {
        this._cookBook = _cookBook;
    }
}
