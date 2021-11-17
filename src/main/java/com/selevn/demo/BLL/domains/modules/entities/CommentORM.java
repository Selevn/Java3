package com.selevn.demo.BLL.domains.modules.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "comments")
@Entity
public class CommentORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private UserORM authorId;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private RecipeORM recipeId;

    @ManyToOne
    @JoinColumn(name = "cookBookId")
    private CookbookORM cookBookId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "text", nullable = false)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CookbookORM getCookBookId() {
        return cookBookId;
    }

    public void setCookBookId(CookbookORM cookBookId) {
        this.cookBookId = cookBookId;
    }

    public RecipeORM getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(RecipeORM recipeId) {
        this.recipeId = recipeId;
    }

    public UserORM getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UserORM authorId) {
        this.authorId = authorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}