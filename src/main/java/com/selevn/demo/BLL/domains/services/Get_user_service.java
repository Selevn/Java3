package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.entities.User;
import com.selevn.demo.BLL.domains.ports.in.Get_user_query;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_user_port;

public class Get_user_service implements Get_user_query {
    private Load_user_port _load_user_port;

    public Get_user_service(Load_user_port _load_user_port) {
        this._load_user_port = _load_user_port;
    }


    @Override
    public User get_user(Integer id) {
        return _load_user_port.load_user(id);
    }
}
