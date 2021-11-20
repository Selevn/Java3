package com.selevn.demo.controller;

import com.selevn.demo.BLL.domains.entities.CookBook;
import com.selevn.demo.forms.AppForm;
import com.selevn.demo.forms.DeleteForm;
import com.selevn.demo.forms.EditForm;
import com.selevn.demo.model.App;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.selevn.demo.BLL.domains.services.Get_cookBook_service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping
public class AppController {
    /*@Autowired
    public UserService userService;*/

    private static List<App> apps = new ArrayList<App>();

    static {
        apps.add(new App("Telegram", "Simple secure messenger"));
        apps.add(new App("Vk", "Simple secure messenger with no music and who checks your messages"));
    }

    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;
    @Value("${error.message.duplicateName}")
    private String errorMessageDuplicateName;
    @Value("${error.message.wrongName}")
    private String errorMessageWrongName;


    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        log.info("/index was called");
        //System.out.println(userService.(3).getFirstName());
        return modelAndView;
    }

    @GetMapping(value = {"/allApps"})
    public ModelAndView personList(Model model) {
        DeleteForm deleteForm = new DeleteForm();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applist");
        model.addAttribute("apps", apps);
        model.addAttribute("deleteForm", deleteForm);
        log.info("/allApps was called");
        return modelAndView;
    }

    @GetMapping(value = {"/addapp"})
    public ModelAndView showAddPersonPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("addapp");
        AppForm appForm = new AppForm();
        model.addAttribute("appform", appForm);
        log.info("/addapp was called");
        return modelAndView;
    }

    @PostMapping(value = {"/addapp"})
    public ModelAndView savePerson(Model model, @ModelAttribute("appform") AppForm appForm) {
        log.info("/addapp POST was called");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applist");
        String name = appForm.getName();
        String description = appForm.getDescription();
        if (name != null && name.length() > 0 //
                && description != null && description.length() > 0) {
            for (App app : apps) {
                if (app.getName().equals(name)) {
                    model.addAttribute("errorMessage", errorMessageDuplicateName);
                    modelAndView.setViewName("addapp");
                    return modelAndView;
                }
            }
            App newApp = new App(name, description);
            apps.add(newApp);
            model.addAttribute("apps", apps);
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
        modelAndView.setViewName("addapp");
        return modelAndView;
    }

    @GetMapping(value = {"/editapp"}, params = "name")
    public ModelAndView showEditPersonPage(Model model, @RequestParam("name") String name) {
        log.info("/editapp was called");
        ModelAndView modelAndView = new ModelAndView("editapp");
        EditForm editForm = new EditForm();
        model.addAttribute("editForm", editForm);
        for (App app : apps) {
            if (app.getName().equals(name)) {
                model.addAttribute("name", app.getName());
                model.addAttribute("desc", app.getDescription());
                modelAndView.setViewName("editapp");
                return modelAndView;
            }
        }
        model.addAttribute("errorMessage", errorMessageWrongName);
        modelAndView.setViewName("editapp");
        return modelAndView;
    }

    @PostMapping(value = {"/editapp"})
    public ModelAndView savePerson(Model model, @ModelAttribute("editForm") EditForm editForm) {
        log.info("/editapp POST was called");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applist");
        String previousName = editForm.getPrevName();
        String description = editForm.getDescription();
        String name = editForm.getName();
        if (name != null && name.length() > 0 //
                && description != null && description.length() > 0) {
            for (App app : apps) {
                if (app.getName().equals(previousName)) {
                    app.setName(name);
                    app.setDescription(description);
                    model.addAttribute("apps", apps);
                    return modelAndView;
                }
            }
            model.addAttribute("errorMessage", errorMessageWrongName);
            modelAndView.setViewName("editapp");
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
        modelAndView.setViewName("editapp");
        return modelAndView;
    }

    @DeleteMapping(value = {"/deleteApp"})
    public ModelAndView deletePerson(Model model, @ModelAttribute("deleteForm") DeleteForm deleteForm) {
        log.info("/deleteApp was called with name = " + deleteForm.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applist");
        String name = deleteForm.getName();
        if (name != null && name.length() > 0) {
            for (App app : apps) {
                if (app.getName().equals(name)) {
                    apps.remove(app);
                    model.addAttribute("apps", apps);
                    return modelAndView;
                }
            }
            model.addAttribute("errorMessage", errorMessageWrongName);
            modelAndView.setViewName("applist");
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
        modelAndView.setViewName("applist");
        return modelAndView;
    }

}
