package com.selevn.demo.BLL.domains.services;


import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_cookBook_command;
import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_recipe_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Create_recipe_use_case;
import com.selevn.demo.BLL.domains.ports.out.db.uploaders.Upload_recipe_port;

public class Create_recipe_service implements Create_recipe_use_case {
    private Upload_recipe_port _uploadRecipe;

    @Override
    public boolean Create_recipe(Create_recipe_command command) {
        return false;
    }
}
