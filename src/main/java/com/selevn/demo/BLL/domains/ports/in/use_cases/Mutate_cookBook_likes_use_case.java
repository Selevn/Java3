package com.selevn.demo.BLL.domains.ports.in.use_cases;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_likes_command;

public interface Mutate_cookBook_likes_use_case {
    public boolean mutate_views(Mutate_likes_command command);
}
