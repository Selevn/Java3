package com.selevn.demo.BLL.domains.modules.entities;

import javax.persistence.*;

@Table(name = "liked")
@Entity
public class LikedORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id", nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeORM recipe;

    @ManyToOne
    @JoinColumn(name = "cook_book_id")
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}