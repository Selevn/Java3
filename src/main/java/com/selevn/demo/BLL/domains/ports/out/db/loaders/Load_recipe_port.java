package com.selevn.demo.BLL.domains.ports.out.db.loaders;

import com.selevn.demo.BLL.domains.entities.Recipe;

import java.util.ArrayList;

public interface Load_recipe_port {
    public Recipe load_recipe(Integer id);
    public ArrayList<Recipe> load_recipes();
}
