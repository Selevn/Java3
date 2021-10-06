package com.selevn.demo.BLL.domains.entities;

import java.util.ArrayList;

public class User {
    private Integer _id;
    private String _name;
    private String _lastName;
    private String _description;
    private ArrayList<CookBook> _likedCookBooks;
    private ArrayList<Recipe> _likedRecipes;
    private ArrayList<CookBook> _createdCookBooks;
    private ArrayList<Recipe> _createdRecipes;
    private String _image;

    public User(Integer _id, String _name, String _lastName, String _description, ArrayList<CookBook> _likedCookBooks, ArrayList<Recipe> _likedRecipes, ArrayList<CookBook> _createdCookBooks, ArrayList<Recipe> _createdRecipes) {
        this._id = _id;
        this._name = _name;
        this._lastName = _lastName;
        this._description = _description;
        this._likedCookBooks = _likedCookBooks;
        this._likedRecipes = _likedRecipes;
        this._createdCookBooks = _createdCookBooks;
        this._createdRecipes = _createdRecipes;
    }

    public String get_image() {
        return _image;
    }

    public void set_image(String _image) {
        this._image = _image;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public ArrayList<CookBook> get_likedCookBooks() {
        return _likedCookBooks;
    }

    public void set_likedCookBooks(ArrayList<CookBook> _likedCookBooks) {
        this._likedCookBooks = _likedCookBooks;
    }

    public ArrayList<Recipe> get_likedRecipes() {
        return _likedRecipes;
    }

    public void set_likedRecipes(ArrayList<Recipe> _likedRecipes) {
        this._likedRecipes = _likedRecipes;
    }

    public ArrayList<CookBook> get_createdCookBooks() {
        return _createdCookBooks;
    }

    public void set_createdCookBooks(ArrayList<CookBook> _createdCookBooks) {
        this._createdCookBooks = _createdCookBooks;
    }

    public ArrayList<Recipe> get_createdRecipes() {
        return _createdRecipes;
    }

    public void set_createdRecipes(ArrayList<Recipe> _createdRecipes) {
        this._createdRecipes = _createdRecipes;
    }

    public boolean CreateCookBook(CookBook book){
        this._createdCookBooks.add(book);
        return true;
    }
    public boolean CreateRecipe(Recipe recipe){
        this._createdRecipes.add(recipe);
        return true;
    }
    public boolean LikeCookBook(CookBook book){
        this._likedCookBooks.add(book);
        return book.addLike();
    }
    public boolean LikeRecipe(Recipe recipe){
        this._likedRecipes.add(recipe);
        return recipe.addLike();
    }

}
