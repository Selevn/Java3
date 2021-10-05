package com.selevn.demo.BLL.domains.entities;

import java.util.ArrayList;

public abstract class AbstractEntity {
    private Integer _id;
    private String _name;
    private String _description;
    private ArrayList<Comment> _comments;
    private Integer _likes;
    private User _creator;

    public AbstractEntity(Integer _id, String _name, String _description, User _creator, ArrayList<Comment> _comments, Integer _likes) {
        this._id = _id;
        this._name = _name;
        this._description = _description;
        this._comments = _comments;
        this._likes = _likes;
        this._creator = _creator;
    }

    public User get_creator() {
        return _creator;
    }

    public void set_creator(User _creator) {
        this._creator = _creator;
    }public Integer get_id() {
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

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }
    public ArrayList<Comment> get_comments() {
        return _comments;
    }

    public void set_comments(ArrayList<Comment> _comments) {
        this._comments = _comments;
    }
    public Integer get_likes() {
        return _likes;
    }

    public void set_likes(Integer _likes) {
        this._likes = _likes;
    }

}
