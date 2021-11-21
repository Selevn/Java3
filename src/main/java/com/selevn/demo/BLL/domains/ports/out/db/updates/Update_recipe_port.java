package com.selevn.demo.BLL.domains.ports.out.db.updates;

import com.selevn.demo.BLL.domains.entities.Recipe;

public interface Update_recipe_port {
    public boolean update_recipe(Recipe recipe);
}
