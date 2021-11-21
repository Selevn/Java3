package com.selevn.demo.BLL.domains.ports.out.db.updates;

import com.selevn.demo.BLL.domains.entities.User;

public interface Update_user_port {
    public boolean update_user(User user);
}
