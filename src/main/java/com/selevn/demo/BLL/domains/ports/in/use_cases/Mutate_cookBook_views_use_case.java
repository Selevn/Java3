package com.selevn.demo.BLL.domains.ports.in.use_cases;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_views_command;

public interface Mutate_cookBook_views_use_case {
    public boolean mutate_views(Mutate_views_command command);
}
