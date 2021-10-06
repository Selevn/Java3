package com.selevn.demo.BLL.domains.ports.out.db.loaders;

import com.selevn.demo.BLL.domains.entities.User;

public interface load_user_port {
    public User load_user(Integer id);
}
