package com.selevn.demo.controller;

import com.selevn.demo.Service.UserService;
import com.selevn.demo.entities.SingleUserEntity;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.utils.jwtToken.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.selevn.demo.utils.password.PasswordProvider.checkPassword;

@Controller
@RequestMapping(value = "/api/login",produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JWTUtil tokenUtil;

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

                final String token = tokenUtil.generateToken(user);
                var expires = tokenUtil.getExpirationDateFromToken(token);

                map.put("success", true);
                map.put("user", user);
                map.put("likedRecipesIds", likedRecipesIds);
                map.put("likedCookBooksIds", likedCookBooksIds);
                map.put("token", "Bearer "+token);
                map.put("expiresIn", expires.getTime());
                logger.info("Loging trying success");
            }
            else{
                logger.info("Loging trying failed: password incorrect");
                map.put("success", false);
                map.put("message", "No user with this credentials");
            }
            return map;
        }
        logger.info("Loging trying failed: no such user");
        map.put("success", false);
        map.put("message", "No user with this credentials");
        return map;
    }
}
