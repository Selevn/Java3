package com.selevn.demo.controller;

import com.selevn.demo.Service.UserService;
import com.selevn.demo.entities.*;
import com.selevn.demo.utils.jwtToken.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/jwt",produces = MediaType.APPLICATION_JSON_VALUE)
public class JWTTestController {

    @Autowired
    private UOF uof;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JWTUtil tokenUtil;

    @GetMapping(value = {"/test"})
    @ResponseBody
    public Map<String, Object> getCookBooks(

    ) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("hasNextPage", "books.hasNext");
        return map;
    }

    @PostMapping(value = {"/login"})
    @ResponseBody
    public Map<String, Object> login(
                @RequestBody Map<String, Object> payload
    ) throws Exception {
        var email = payload.get("email").toString();
        var password = payload.get("password").toString();
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    email, password
            ));
        } catch (BadCredentialsException e){
            throw new Exception("INVALID CREDITS",e);
        }

        final SingleUserEntity userDetails = userDetailsService.loadUserByUsername(email);
        final String token = tokenUtil.generateToken(userDetails);


        map.put("token", token);
        return map;
    }
}
