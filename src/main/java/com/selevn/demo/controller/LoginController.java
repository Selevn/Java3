package com.selevn.demo.controller;

import com.selevn.demo.entities.UOF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.selevn.demo.utils.password.PasswordProvider.checkPassword;

@Controller
@RequestMapping(value = "/api/login",produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Autowired
    private UOF uof;

    @PostMapping(value = {"/login"})
    @ResponseBody
    public Map<String, Object> login(
            @RequestBody Map<String, Object> payload
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        var email = payload.get("email").toString();
        var password = payload.get("password").toString();
        var user = uof.getUserForLogin(email);
        if(user != null){
            if(checkPassword(password,user.getPassword(),user.getSalt()))
            {
                var likedRecipesIds = uof.getAllUserLikedRecipesIds(user.getId());
                var likedCookBooksIds = uof.getAllUserLikedCookBooksIds(user.getId());

                map.put("success", true);
                map.put("user", user);
                map.put("likedRecipesIds", likedRecipesIds);
                map.put("likedCookBooksIds", likedCookBooksIds);
                map.put("token", "Bearer");
                map.put("expiresIn", "ExpiresIn");
            }
            else{
                map.put("success", true);
                map.put("message", "No user with this credentials");
            }
            return map;
        }
        map.put("success", false);
        map.put("message", "No user with this credentials");
        return map;
    }
}
