package com.selevn.demo.BLL.domains.ports.in.use_cases;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_add_comment_command;

public interface Mutate_add_comment_use_case {
    public boolean mutate_add_comment(Mutate_add_comment_command command);
}
