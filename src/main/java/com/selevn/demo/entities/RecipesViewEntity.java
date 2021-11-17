package com.selevn.demo.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "recipes_view", schema = "public", catalog = "cookbook")
public class RecipesViewEntity {
    @Id
    @Column(name = "_id", nullable = false)
    private Integer id;
    private Long views;
    private String image;
    private Long cookTime;
    private Date creationDate;
    private Long author;
    private String name;
    private String desc;
    private String ingredients;
    private String directions;
    private Long likes;
    private Long comments;
    private String personimage;
    private String firstName;
    private String lastName;

    @Basic
    @Column(name = "_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "views")
    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "cook_time")
    public Long getCookTime() {
        return cookTime;
    }

    public void setCookTime(Long cookTime) {
        this.cookTime = cookTime;
    }

    @Basic
    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "author")
    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "ingredients")
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Basic
    @Column(name = "directions")
    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    @Basic
    @Column(name = "likes")
    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "comments")
    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "personimage")
    public String getPersonimage() {
        return personimage;
    }

    public void setPersonimage(String personimage) {
        this.personimage = personimage;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipesViewEntity that = (RecipesViewEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (views != null ? !views.equals(that.views) : that.views != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (cookTime != null ? !cookTime.equals(that.cookTime) : that.cookTime != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (ingredients != null ? !ingredients.equals(that.ingredients) : that.ingredients != null) return false;
        if (directions != null ? !directions.equals(that.directions) : that.directions != null) return false;
        if (likes != null ? !likes.equals(that.likes) : that.likes != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (personimage != null ? !personimage.equals(that.personimage) : that.personimage != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (views != null ? views.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (cookTime != null ? cookTime.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (directions != null ? directions.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (personimage != null ? personimage.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
