package com.selevn.demo.BLL.domains.ports.in.use_cases;

import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_comment_command;

public interface Create_comment_use_case {
    public boolean Create_comment(Create_comment_command command);
}
