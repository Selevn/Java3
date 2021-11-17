package com.selevn.demo.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comments_view", schema = "public", catalog = "cookbook")
public class CommentsViewEntity {
    @Id
    @Column(name = "_id", nullable = false)
    private Integer id;
    private Long recipeId;
    private Long cookbookId;
    private Date date;
    private String text;
    private Integer authorId;
    private String firstName;
    private String lastName;
    private String image;

    @Basic
    @Column(name = "_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "recipe_id")
    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    @Basic
    @Column(name = "cookbook_id")
    public Long getCookbookId() {
        return cookbookId;
    }

    public void setCookbookId(Long cookbookId) {
        this.cookbookId = cookbookId;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "author_id")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
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

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentsViewEntity that = (CommentsViewEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipeId != null ? !recipeId.equals(that.recipeId) : that.recipeId != null) return false;
        if (cookbookId != null ? !cookbookId.equals(that.cookbookId) : that.cookbookId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recipeId != null ? recipeId.hashCode() : 0);
        result = 31 * result + (cookbookId != null ? cookbookId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
