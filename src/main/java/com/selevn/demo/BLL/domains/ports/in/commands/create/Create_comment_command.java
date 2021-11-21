package com.selevn.demo.BLL.domains.ports.in.commands.create;

import com.selevn.demo.BLL.domains.entities.Comment;

public class Create_comment_command {
    private Integer _userId;
    private Integer _cookBookId;
    private Comment _comment;

    public Create_comment_command(Integer _userId, Integer _cookBookId, Comment _comment) {
        this._userId = _userId;
        this._cookBookId = _cookBookId;
        this._comment = _comment;
    }

    public Integer get_userId() {
        return _userId;
    }

    public void set_userId(Integer _userId) {
        this._userId = _userId;
    }

    public Integer get_cookBookId() {
        return _cookBookId;
    }

    public void set_cookBookId(Integer _cookBookId) {
        this._cookBookId = _cookBookId;
    }

    public Comment get_comment() {
        return _comment;
    }

    public void set_comment(Comment _comment) {
        this._comment = _comment;
    }
}
