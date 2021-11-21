package com.selevn.demo.BLL.domains.ports.out.db.uploaders;

import com.selevn.demo.BLL.domains.entities.Recipe;

import java.util.ArrayList;

public interface Upload_recipe_port {
    public Recipe upload_recipe(Integer id);
    public ArrayList<Recipe> upload_recipes();
}
