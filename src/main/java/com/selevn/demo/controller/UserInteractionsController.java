package com.selevn.demo.controller;

import com.selevn.demo.entities.UOF;
import com.selevn.demo.utils.TypeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/userInteractions",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserInteractionsController {

    @Autowired
    private UOF uof;

    @PostMapping(value = {"/likeCookBook"})
    @ResponseBody
    public Map<String, Object> likeCookBook(
            @RequestBody Map<String, Object> payload
    ) {
        Map<String, Object> map = new HashMap<String, Object>();

        var likeResult = uof.likeCookBook(
                Integer.parseInt(payload.get("from").toString()),
                Integer.parseInt(payload.get("to").toString()));
        map.put("success", likeResult);
        return map;
    }

    @PostMapping(value = {"/likeRecipe"})
    @ResponseBody
    public Map<String, Object> likeRecipe(
            @RequestBody Map<String, Object> payload
    ) {
        Map<String, Object> map = new HashMap<String, Object>();

        var likeResult = uof.likeRecipe(
                Integer.parseInt(payload.get("from").toString()),
                Integer.parseInt(payload.get("to").toString())
        );
        map.put("success", likeResult);
        return map;
    }
    @PostMapping(value = {"/visitItem"})
    @ResponseBody
    public Map<String, Object> visitItem(
            @RequestBody Map<String, Object> payload
    ) {
        Map<String, Object> map = new HashMap<String, Object>();

        var visitResult = uof.visitItem(
                Integer.parseInt(payload.get("to").toString()),
                TypeParser.parse(payload.get("type").toString())
        );
        map.put("success", visitResult);
        return map;
    }
}
