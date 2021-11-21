package com.selevn.demo.BLL.domains.ports.in.commands.mutate;

public class Mutate_likes_command {
    private Integer _sourceAccountId;
    private Integer _targetId;


    public Mutate_likes_command(Integer _sourceAccountId, Integer _targetId) {
        this._sourceAccountId = _sourceAccountId;
        this._targetId = _targetId;
    }

    public Integer get_sourceAccountId() {
        return _sourceAccountId;
    }

    public void set_sourceAccountId(Integer _sourceAccountId) {
        this._sourceAccountId = _sourceAccountId;
    }

    public Integer get_targetId() {
        return _targetId;
    }

    public void set_targetId(Integer _targetId) {
        this._targetId = _targetId;
    }
}
