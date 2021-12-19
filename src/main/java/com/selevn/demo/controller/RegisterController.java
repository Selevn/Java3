package com.selevn.demo.controller;

import com.selevn.demo.Service.MailSenderService;
import com.selevn.demo.Service.UserService;
import com.selevn.demo.config.EmailConfig;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.utils.jwtToken.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.Map;

import static com.selevn.demo.utils.password.PasswordProvider.*;

@Controller
@RequestMapping(value = "/api/login",produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {


    @Autowired
    private UserService userDetailsService;

    @Autowired
    private MailSenderService mailSender;

    @Autowired
    private JWTUtil tokenUtil;

    @Autowired
    private UOF uof;

    @PostMapping(value = {"/register"})
    @ResponseBody
    public Map<String, Object> login(
            @RequestBody Map<String, Object> payload
    ) throws ValidationException {
        Map<String, Object> map = new HashMap<String, Object>();
        var email = payload.get("email").toString();
        var password = payload.get("password").toString();
        var user = uof.getUserForLogin(email);
        if(user != null)
            throw new ValidationException("Such user exists");
        String salt = genSalt();
        String hashedPassword = genHash(password, salt);
        boolean success = uof.createUser(email,hashedPassword,salt);
        //email approvement!
        if(success)
            mailSender.sendMail(email, "Welcome to FedMe!", "Thank you for registration on our portal!");
        map.put("success", success);
        return map;
    }
}
