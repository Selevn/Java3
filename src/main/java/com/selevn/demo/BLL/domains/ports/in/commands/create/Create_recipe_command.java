package com.selevn.demo.BLL.domains.ports.in.commands.create;

import com.selevn.demo.BLL.domains.entities.Recipe;

public class Create_recipe_command {
    private Integer _userId;
    private Recipe _recipe;

    public Create_recipe_command(Integer _userId, Recipe _recipe) {
        this._userId = _userId;
        this._recipe = _recipe;
    }

    public Integer get_userId() {
        return _userId;
    }

    public void set_userId(Integer _userId) {
        this._userId = _userId;
    }

    public Recipe get_recipe() {
        return _recipe;
    }

    public void set_recipe(Recipe _recipe) {
        this._recipe = _recipe;
    }
}
