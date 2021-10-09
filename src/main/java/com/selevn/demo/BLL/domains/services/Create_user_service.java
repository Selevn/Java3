package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_user_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Create_user_use_case;
import com.selevn.demo.BLL.domains.ports.out.db.uploaders.Upload_user_port;

public class Create_user_service implements Create_user_use_case {

    private Upload_user_port _upload_user;

    @Override
    public boolean Create_user(Create_user_command command) {
        return _upload_user.upload_user(command.get_user());
    }
}
