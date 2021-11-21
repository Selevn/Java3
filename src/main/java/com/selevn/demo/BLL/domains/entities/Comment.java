package com.selevn.demo.BLL.domains.entities;

import java.util.Date;

public class Comment {
    private Integer _id;
    private User _creator;
    private String _text;
    private Date _publishDate;
    private AbstractEntity _item;

    public Comment(Integer _id, User _creator, String _text, Date _publishDate, AbstractEntity _item) {
        this._id = _id;
        this._creator = _creator;
        this._text = _text;
        this._publishDate = _publishDate;
        this._item = _item;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public User get_creator() {
        return _creator;
    }

    public void set_creator(User _creator) {
        this._creator = _creator;
    }

    public String get_text() {
        return _text;
    }

    public void set_text(String _text) {
        this._text = _text;
    }

    public Date get_publishDate() {
        return _publishDate;
    }

    public void set_publishDate(Date _publishDate) {
        this._publishDate = _publishDate;
    }

    public AbstractEntity get_item() {
        return _item;
    }

    public void set_item(AbstractEntity _item) {
        this._item = _item;
    }


}
