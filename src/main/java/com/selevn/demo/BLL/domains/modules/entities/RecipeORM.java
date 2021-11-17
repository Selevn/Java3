package com.selevn.demo.BLL.domains.modules.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "recipes")
@Entity
public class RecipeORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id", nullable = false)
    private Integer id;

    @Column(name = "views", nullable = false)
    private Long views;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "cook_time", nullable = false)
    private Long cookTime;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "author")
    private UserORM author;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "\"desc\"", nullable = false)
    private String desc;

    @Column(name = "ingredients", nullable = false)
    private String ingredients;

    @Column(name = "directions", nullable = false)
    private String directions;

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserORM getAuthor() {
        return author;
    }

    public void setAuthor(UserORM author) {
        this.author = author;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCookTime() {
        return cookTime;
    }

    public void setCookTime(Long cookTime) {
        this.cookTime = cookTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}