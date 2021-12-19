package com.selevn.demo.controller.userInput;

import com.selevn.demo.utils.TypeParser;

import java.util.Map;

public class VisitItem {
    private Integer to;
    private String type;

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public Integer getTypeParsed() {
        return TypeParser.parse(type);
    }

    public void setType(String from) {
        this.type = from;
    }
}
