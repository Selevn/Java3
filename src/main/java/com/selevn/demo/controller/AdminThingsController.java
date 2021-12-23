package com.selevn.demo.controller;

import com.selevn.demo.entities.UOF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/adminData",produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminThingsController {

    @Autowired
    private UOF uof;

    @DeleteMapping(value = {"/deleteUser/{userId}"})
    @ResponseBody
    public Map<String, Object> getUserCookBooks(
            @PathVariable("userId") String userId
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            map.put("success",uof.deleteUser(Integer.parseInt(userId)));

            if(uof.getUser(Integer.parseInt(userId)) == null){
                map.put("success", false);
                return map;
            }

        } catch (Exception e){
            map.put("success", false);
        }
        return map;
    }
    @DeleteMapping(value = {"/deleteBook/{userId}"})
    @ResponseBody
    public Map<String, Object> deleteBook(
            @PathVariable("userId") String userId
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            if(uof.getSingleCookBook(Integer.parseInt(userId)) == null){
                map.put("success", false);
                return map;
            }

            map.put("success",uof.deleteBook(Integer.parseInt(userId)));
        } catch (Exception e){
            map.put("success", false);
        }
        return map;
    }
    @DeleteMapping(value = {"/deleteRecipe/{userId}"})
    @ResponseBody
    public Map<String, Object> deleteRecipe(
            @PathVariable("userId") String userId
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            if(uof.getSingleRecipe(Integer.parseInt(userId)) == null){
                map.put("success", false);
                return map;
            }
            map.put("success",uof.deleteRecipe(Integer.parseInt(userId)));
        } catch (Exception e){
            map.put("success", false);
        }
        return map;
    }
}
