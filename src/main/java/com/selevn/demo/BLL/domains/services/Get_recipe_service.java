package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.entities.Recipe;
import com.selevn.demo.BLL.domains.ports.in.Get_recipe_query;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_cookBook_port;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_recipe_port;

import java.util.ArrayList;

public class Get_recipe_service implements Get_recipe_query {
    private Load_recipe_port _loadRecipePort;

    public Get_recipe_service(Load_recipe_port loadRecipePort) {
        this._loadRecipePort = loadRecipePort;
    }

    @Override
    public Recipe get_recipe_query(Integer id) {
        return _loadRecipePort.load_recipe(id);
    }

    @Override
    public ArrayList<Recipe> get_all_recipes_query() {
        return _loadRecipePort.load_recipes();
    }
}
