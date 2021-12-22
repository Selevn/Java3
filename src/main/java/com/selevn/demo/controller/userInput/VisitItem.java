package com.selevn.demo.controller.userInput;

import com.selevn.demo.utils.TypeParser;
import com.selevn.demo.validators.TypeValidation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class VisitItem {
    @NotNull(message="Id must be filled")
    @Positive(message="Id must be positive")
    private Integer to;

    @NotEmpty(message="Type must be filled")
    @TypeValidation(message = "Incorrect type")
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
