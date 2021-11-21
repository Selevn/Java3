package com.selevn.demo.BLL.domains.entities;

import java.util.ArrayList;

public class Recipe extends AbstractEntity {

    public Recipe(Integer _id, String _name, String _description, User _creator, ArrayList<Comment> _comments, Integer _likes) {
        super(_id, _name, _description, _creator, _comments, _likes);
    }
}
