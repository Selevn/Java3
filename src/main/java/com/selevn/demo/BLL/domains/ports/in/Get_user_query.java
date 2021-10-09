package com.selevn.demo.BLL.domains.ports.in;

import com.selevn.demo.BLL.domains.entities.User;

public interface Get_user_query {
    public User get_user(Integer id);
}
