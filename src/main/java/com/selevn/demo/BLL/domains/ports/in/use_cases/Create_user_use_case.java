package com.selevn.demo.BLL.domains.ports.in.use_cases;

import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_cookBook_command;
import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_user_command;

public interface Create_user_use_case {
    public boolean Create_user(Create_user_command command);
}
