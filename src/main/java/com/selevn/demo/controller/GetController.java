package com.selevn.demo.controller;

import com.selevn.demo.entities.UOF;
import com.selevn.demo.utils.HideMyParser;
import com.selevn.demo.utils.SortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/get",produces = MediaType.APPLICATION_JSON_VALUE)
public class GetController {

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
            @RequestParam(required = false) String searchString
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(page == null)
            page = 1;
        var recipes = uof.getRecipes(page-1,
                SortMapper.sortParse(sortBy),
                cookTime,
                HideMyParser.parse(hideMy),
                searchString);

        map.put("docs", recipes.docs);
        map.put("total", recipes.total);
        map.put("nextPage", recipes.nextPage);
        map.put("hasNextPage", recipes.hasNext);
        return map;
    }
    /*
    @GetMapping(value = {"/api/getCookBook"})
    public ModelAndView personList(Model model) {
        DeleteForm deleteForm = new DeleteForm();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applist");
        model.addAttribute("deleteForm", deleteForm);
        return modelAndView;
    }
    @GetMapping(value = {"/api/getRecipes"})
    public ModelAndView personList(Model model) {
        DeleteForm deleteForm = new DeleteForm();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applist");
        model.addAttribute("deleteForm", deleteForm);
        return modelAndView;
    }
    @GetMapping(value = {"/api/getRecipe"})
    public ModelAndView personList(Model model) {
        DeleteForm deleteForm = new DeleteForm();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applist");
        model.addAttribute("deleteForm", deleteForm);
        return modelAndView;
    }*/

}
