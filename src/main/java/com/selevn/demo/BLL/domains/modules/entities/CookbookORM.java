package com.selevn.demo.BLL.domains.modules.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "cookbooks")
@Entity
public class CookbookORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id", nullable = false)
    private Integer id;

    @Column(name = "views", nullable = false)
    private Long views;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "filters", nullable = false)
    private String filters;

    @Column(name = "creationDate", nullable = false)
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "author")
    private UserORM author;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "\"desc\"", nullable = false)
    private String desc;

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

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
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