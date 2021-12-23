package com.selevn.demo.controller;

import com.selevn.demo.entities.UOF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/check",produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckController {

    @Autowired
    private UOF uof;

    @GetMapping(value = {"/profile"})
    @ResponseBody
    public String checkProfile(
            @RequestParam(required = false) Integer id
    ) {
        var count = uof.getUser(id);
        if(count != null)
            return "Ok";
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Not ok"
        );/*
        if(count >= id){
            return "Ok";
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not ok"
            );
        }*/
    }

    @GetMapping(value = {"/cookbook"})
    @ResponseBody
    public String checkCookBook(
            @RequestParam(required = false) Integer id
    ) {
        var count = uof.getSingleCookBook(id);
        if(count != null)
            return "Ok";
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Not ok"
        );/*
        var count = uof.getTotalCookBooksCount();
        if(count >= id){
            return "Ok";
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not ok"
            );
        }*/
    }

    @GetMapping(value = {"/recipe"})
    @ResponseBody
    public String checkRecipe(
            @RequestParam(required = false) Integer id
    ) {
        var count = uof.getSingleRecipe(id);
        if(count != null)
            return "Ok";
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Not ok"
        );
        /*
        var count = uof.getTotalRecipesCount();
        if(count >= id){
            return "Ok";
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not ok"
            );
        }*/
    }

}
