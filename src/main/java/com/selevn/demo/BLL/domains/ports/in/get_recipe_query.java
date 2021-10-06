package com.selevn.demo.BLL.domains.ports.in;

import com.selevn.demo.BLL.domains.entities.Recipe;

import java.util.ArrayList;

public interface get_recipe_query {
    public Recipe get_recipe_query(Integer id);
    public ArrayList<Recipe> get_all_recipes_query();
}
