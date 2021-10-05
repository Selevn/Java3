package com.selevn.demo.BLL.domains.entities;

import java.util.ArrayList;

public class CookBook extends AbstractEntity {

    private ArrayList<Recipe> _recipes;
    private ArrayList<Comment> _comments;



    public CookBook(Integer _id, String _name, String _description, User _creator, ArrayList<Comment> _comments, Integer _likes, ArrayList<Recipe> _recipes) {
        super(_id, _name, _description, _creator, _comments, _likes);
        this._recipes = _recipes;
    }


    public ArrayList<Recipe> get_recipes() {
        return _recipes;
    }

    public void set_recipes(ArrayList<Recipe> _recipes) {
        this._recipes = _recipes;
    }


}
