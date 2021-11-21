package com.selevn.demo.controller;

import com.selevn.demo.Service.CloudinaryOutput;
import com.selevn.demo.Service.CloudinaryUploadService;
import com.selevn.demo.Service.UserService;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.utils.jwtToken.JWTUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/create",produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateController {


    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JWTUtil tokenUtil;

    @Autowired
    private UOF uof;

    /*@PostMapping(value = {"/newCookBook"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Map<String, Object> newCookbook(

    ) {
        Map<String, Object> map = new HashMap<String, Object>();

        //email approvement!
        map.put("success", "success");
        return map;
    }*/
    @PostMapping(path = "/newCookBook", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    @ResponseBody
    public Map<String, Object> saveEmployee(
            @RequestParam("image") MultipartFile image,
            @RequestParam("author") String author,
            @RequestParam("name") String name,
            @RequestParam("desc") String desc,
            @RequestParam("recipesIds") String recipesIds,
            @RequestParam("creationDate") String creationDate,
            @RequestParam("filters") String filters
            ) throws IOException, JSONException {
        File conver = new File("/Users/selevn/3kurs/Ptsei/files/"+image.getOriginalFilename());
        conver.createNewFile();
        try (FileOutputStream fout = new FileOutputStream(conver)){
                fout.write(image.getBytes());
        } catch (Exception e){
            //e.printStackTrace();
        }

        char[] byteFilter = new char[4];
        byteFilter[0] = 'b';
        byteFilter[1] = '0';
        byteFilter[2] = '0';
        byteFilter[3] = '0';
        JSONArray jsonFilters = new JSONArray(filters);
        for (int i = 0; i < jsonFilters.length(); i++) {
            if(jsonFilters.getString(i).equals("vegeterian"))
                byteFilter[1] = '1';
            if(jsonFilters.getString(i).equals("noMilk"))
                byteFilter[2] = '1';
            if(jsonFilters.getString(i).equals("noEggs"))
                byteFilter[3] = '1';
        }

        ArrayList<Integer> ids = new ArrayList<Integer>();
        JSONArray recipes = new JSONArray(recipesIds);
        for (int i = 0; i < recipes.length(); i++) {
            ids.add(recipes.getInt(i));
        }

        CloudinaryUploadService service = CloudinaryUploadService.getInstance();
        CloudinaryOutput data = service.loadImage("/Users/selevn/3kurs/Ptsei/files/"+image.getOriginalFilename());
        var id = uof.createCookbook(
            data.getUrl(),
            new String(byteFilter),
            Integer.parseInt(author),
            name,
            desc
        );

        uof.addRecipesToBook(id, ids);

        Map<String, Object> map = new HashMap<String, Object>();

        //email approvement!
        map.put("success", true);
        map.put("id", id);
        return map;
    }
}
