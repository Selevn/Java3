package com.selevn.demo.controller;

import com.selevn.demo.Service.UserService;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.utils.jwtToken.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static com.selevn.demo.utils.password.PasswordProvider.*;

@Controller
@RequestMapping(value = "/api/login",produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {


    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JWTUtil tokenUtil;

    @Autowired
    private UOF uof;

    @PostMapping(value = {"/register"})
    @ResponseBody
    public Map<String, Object> login(
            @RequestBody Map<String, Object> payload
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        var email = payload.get("email").toString();
        var password = payload.get("password").toString();
        var user = uof.getUserForLogin(email);
        String salt = genSalt();
        String hashedPassword = genHash(password, salt);
        boolean success = uof.createUser(email,hashedPassword,salt);
        //email approvement!
        map.put("success", success);
        return map;
    }
}
