package com.selevn.demo.controller;

import com.selevn.demo.entities.*;
import com.selevn.demo.entities.wrapper.EntityWrapper;
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
@RequestMapping(value = "/api/get",produces = MediaType.APPLICATION_JSON_VALUE)
public class GetItemController {

    @Autowired
    private UOF uof;

    @GetMapping(value = {"/cookbooks"})
    @ResponseBody
    public Map<String, Object> getCookBooks(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) Boolean vegeterian,
            @RequestParam(required = false) Boolean noMilk,
            @RequestParam(required = false) Boolean noEggs,
            @RequestParam(required = false) String hideMy,
            @RequestParam(required = false) String searchString
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(page == null)
            page = 1;
        var books = uof.getCookBooks(page-1,
                SortMapper.sortParse(sortBy),
                vegeterian,noMilk,noEggs,
                HideMyParser.parse(hideMy),searchString);

        map.put("docs", books.docs);
        map.put("total", books.total);
        map.put("nextPage", books.nextPage);
        map.put("hasNextPage", books.hasNext);
        return map;
    }

    @GetMapping(value = {"/recipes"})
    @ResponseBody
    public Map<String, Object> getRecipes(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) Integer cookTime,
            @RequestParam(required = false) String hideMy,
            @RequestParam(required = false) String searchString,
            @RequestParam(required = false) String cookbookId
    ) {
        EntityWrapper<RecipesViewEntity> recipes;
        Map<String, Object> map = new HashMap<String, Object>();
        if(page == null)
            page = 1;
        if(cookbookId != null){
            recipes = uof.getRecipesByCookBook(page-1, Integer.parseInt(cookbookId));
        }
        else
        {   recipes = uof.getRecipes(page-1,
                SortMapper.sortParse(sortBy),
                cookTime,
                HideMyParser.parse(hideMy),
                searchString);}

        map.put("docs", recipes.docs);
        map.put("total", recipes.total);
        map.put("nextPage", recipes.nextPage);
        map.put("hasNextPage", recipes.hasNext);
        return map;
    }

    @GetMapping(value = {"/recipes/{id}"})
    @ResponseBody
    public List<SingleRecipeViewEntity> getSingleRecipe(
            @PathVariable("id") String id
    ) {
        var recipe = uof.getSingleRecipe(Integer.parseInt(id));
        var list = new ArrayList<SingleRecipeViewEntity>();
        list.add(recipe);
        return list;
    }
    @GetMapping(value = {"/cookbooks/{id}"})
    @ResponseBody
    public List<SingleCookbookViewEntity> getSingleCookBook(
            @PathVariable("id") String id
    ) {
        var cookbook = uof.getSingleCookBook(Integer.parseInt(id));
        var list = new ArrayList<SingleCookbookViewEntity>();
        list.add(cookbook);
        return list;
    }


    @GetMapping(value = {"/users/{id}"})
    @ResponseBody
    public List<UserNoPrivateViewEntity> getUser(
            @PathVariable("id") String id
    ) {
        var user = uof.getUser(
                Integer.parseInt(id)
        );
        var users = new ArrayList<UserNoPrivateViewEntity>();
        users.add(user);
        return users;
    }

    @GetMapping(value = {"/comments"})
    @ResponseBody
    public Map<String, Object> getComments(
            @RequestParam(required = true) String type,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = true) Integer itemId
    ) {
        if(page == null)
            page = 1;

        var comments = uof.getComments(
                itemId, TypeParser.parse(type),page-1
        );
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("docs", comments.docs);
        map.put("total", comments.total);
        map.put("nextPage", comments.nextPage);
        map.put("hasNextPage", comments.hasNext);
        return map;
    }


}
