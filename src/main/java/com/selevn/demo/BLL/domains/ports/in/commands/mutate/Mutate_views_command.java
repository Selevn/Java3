package com.selevn.demo.BLL.domains.ports.in.commands.mutate;

public class Mutate_views_command {
    private Integer _targetId;

    public Mutate_views_command(Integer _targetId) {
        this._targetId = _targetId;
    }

    public Integer get_targetId() {
        return _targetId;
    }

    public void set_targetId(Integer _targetId) {
        this._targetId = _targetId;
    }
}
