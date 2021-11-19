package com.selevn.demo.controller;

import com.selevn.demo.entities.UOF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        var user = uof.getUserForLogin();
        /*map.put("docs", books.docs);
        map.put("total", books.total);
        map.put("nextPage", books.nextPage);*/
        map.put("hasNextPage", "books.hasNext");
        return map;
    }
}
