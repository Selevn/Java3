package com.selevn.demo.BLL.domains.ports.in.commands.create;

import com.selevn.demo.BLL.domains.entities.User;

public class Create_user_command {
    private User _user;

    public Create_user_command(User _user) {
        this._user = _user;
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }
}
