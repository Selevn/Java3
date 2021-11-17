/*
package com.selevn.demo.BLL.domains.modules.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "recipes_in_cookbooks")
@Entity
public class RecipesInCookbookORM {
    @ManyToOne(optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private RecipeORM recipe;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cook_book_id", nullable = false)
    private CookbookORM cookBook;

    public CookbookORM getCookBook() {
        return cookBook;
    }

    public void setCookBook(CookbookORM cookBook) {
        this.cookBook = cookBook;
    }

    public RecipeORM getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeORM recipe) {
        this.recipe = recipe;
    }
}*/
