package com.selevn.demo.controller;

import com.selevn.demo.entities.SingleCookbookViewEntity;
import com.selevn.demo.entities.SingleRecipeViewEntity;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.entities.UserNoPrivateViewEntity;
import com.selevn.demo.utils.HideMyParser;
import com.selevn.demo.utils.SortMapper;
import com.selevn.demo.utils.TypeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/userData",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserThingsController {

    @Autowired
    private UOF uof;

    @GetMapping(value = {"/cookbooks/{userId}"})
    @ResponseBody
    public Map<String, Object> getUserCookBooks(
            @PathVariable("userId") String userId,
            @RequestParam(required = false) Integer page
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(page == null)
            page = 1;
        var books = uof.getUserCookBooks(
                Integer.parseInt(userId),
                page-1);
        map.put("docs", books.docs);
        map.put("total", books.total);
        map.put("nextPage", books.nextPage);
        map.put("hasNextPage", books.hasNext);
        return map;
    }
    @GetMapping(value = {"/liked/cookbooks/{userId}"})
    @ResponseBody
    public Map<String, Object> getUserLikedCookBooks(
            @PathVariable("userId") String userId,
            @RequestParam(required = false) Integer page
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(page == null)
            page = 1;
        var books = uof.getUserLikedCookBooks(
                Integer.parseInt(userId),
                page-1);
        map.put("docs", books.docs);
        map.put("total", books.total);
        map.put("nextPage", books.nextPage);
        map.put("hasNextPage", books.hasNext);
        return map;
    }

    @GetMapping(value = {"/liked/recipes/{userId}"})
    @ResponseBody
    public Map<String, Object> getUserLikedRecipes(
            @PathVariable("userId") String userId,
            @RequestParam(required = false) Integer page
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(page == null)
            page = 1;
        var books = uof.getUserLikedRecipes(
                Integer.parseInt(userId),
                page-1);
        map.put("docs", books.docs);
        map.put("total", books.total);
        map.put("nextPage", books.nextPage);
        map.put("hasNextPage", books.hasNext);
        return map;
    }

    @GetMapping(value = {"/recipes/{userId}"})
    @ResponseBody
    public Map<String, Object> getUserRecipes(
            @PathVariable("userId") String userId,
            @RequestParam(required = false) Integer page
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(page == null)
            page = 1;
        var books = uof.getUserRecipes(
                Integer.parseInt(userId),
                page-1);
        map.put("docs", books.docs);
        map.put("total", books.total);
        map.put("nextPage", books.nextPage);
        map.put("hasNextPage", books.hasNext);
        return map;
    }

}
