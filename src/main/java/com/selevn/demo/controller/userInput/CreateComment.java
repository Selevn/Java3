package com.selevn.demo.controller.userInput;

import com.selevn.demo.utils.TypeParser;

public class CreateComment {
    private String type;
    private Integer author;
    private Integer itemId;
    private String text;

    public String getType() {
        return type;
    }
    public Integer parseType(){
        return TypeParser.parse(this.type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
