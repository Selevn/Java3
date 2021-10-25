package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_views_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Mutate_recipe_views_use_case;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_recipe_port;
import com.selevn.demo.BLL.domains.ports.out.db.updates.Update_recipe_port;

public class Mutate_recipe_views_service implements Mutate_recipe_views_use_case {
    private Load_recipe_port load_recipe_port;
    private Update_recipe_port update_recipe_port;

    public Mutate_recipe_views_service(Load_recipe_port load_recipe_port, Update_recipe_port update_recipe_port) {
        this.load_recipe_port = load_recipe_port;
        this.update_recipe_port = update_recipe_port;
    }

    @Override
    public boolean mutate_views(Mutate_views_command command) {
        var recipe = load_recipe_port.load_recipe(command.get_targetId());
        recipe.addView();
        return update_recipe_port.update_recipe(recipe);
    }
}
