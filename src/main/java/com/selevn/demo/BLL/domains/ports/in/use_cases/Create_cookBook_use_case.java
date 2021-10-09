package com.selevn.demo.BLL.domains.ports.in.use_cases;

import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_cookBook_command;

public interface Create_cookBook_use_case {
    public boolean Create_cookBook(Create_cookBook_command command);
}

