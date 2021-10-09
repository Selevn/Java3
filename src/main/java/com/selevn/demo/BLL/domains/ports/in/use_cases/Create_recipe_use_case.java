package com.selevn.demo.BLL.domains.ports.in.use_cases;

import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_cookBook_command;

public interface Create_recipe_use_case {
    public boolean Create_recipe(Create_cookBook_command command);
}
