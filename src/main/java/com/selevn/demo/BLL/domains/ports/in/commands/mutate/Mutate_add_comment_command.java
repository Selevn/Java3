package com.selevn.demo.BLL.domains.ports.in.commands.mutate;

import com.selevn.demo.BLL.domains.entities.Comment;

public class Mutate_add_comment_command {
    private Integer _userId;
    private Integer _itemId;
    private Comment _comment;

    public Mutate_add_comment_command(Integer _userId, Integer _itemId, Comment _comment) {
        this._userId = _userId;
        this._itemId = _itemId;
        this._comment = _comment;
    }

    public Integer get_userId() {
        return _userId;
    }

    public void set_userId(Integer _userId) {
        this._userId = _userId;
    }

    public Integer get_itemId() {
        return _itemId;
    }

    public void set_itemId(Integer _itemId) {
        this._itemId = _itemId;
    }

    public Comment get_comment() {
        return _comment;
    }

    public void set_comment(Comment _comment) {
        this._comment = _comment;
    }
}
