package com.selevn.demo.controller;

import com.selevn.demo.Service.CloudinaryOutput;
import com.selevn.demo.Service.CloudinaryUploadService;
import com.selevn.demo.Service.UserService;
import com.selevn.demo.config.EmailConfig;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.utils.jwtToken.JWTUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/edit",produces = MediaType.APPLICATION_JSON_VALUE)
public class EditController {

    Logger logger = LoggerFactory.getLogger(EditController.class);


    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JWTUtil tokenUtil;

    @Autowired
    private UOF uof;

    @PostMapping(path = "/editCookBook", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    @ResponseBody
    public Map<String, Object> newCookBook(
            @RequestParam("image") Object image,
            @RequestParam("_id") Integer _id,
            @RequestParam("author") String author,
            @RequestParam("name") String name,
            @RequestParam("desc") String desc,
            @RequestParam("recipesIds") String recipesIds,
            @RequestParam("creationDate") String creationDate,
            @RequestParam("filters") String filters
            ) throws IOException, JSONException {
        String img = "";
        if(image.getClass().equals(String.class)){
            img = image.toString();
        }
        if(image.getClass().equals(MultipartFile.class)){
            MultipartFile fileImage = (MultipartFile) image;
            File conver = new File("/Users/selevn/3kurs/Ptsei/files/"+fileImage.getOriginalFilename());
            conver.createNewFile();
            try (FileOutputStream fout = new FileOutputStream(conver)){
                fout.write(fileImage.getBytes());
            } catch (Exception e){
                e.printStackTrace();
            }
            //todo: change on update
            CloudinaryUploadService service = CloudinaryUploadService.getInstance();
            CloudinaryOutput data = service.loadImage("/Users/selevn/3kurs/Ptsei/files/"+fileImage.getOriginalFilename());
            img = data.getUrl();
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

        var id = uof.editCookBook(
                _id,
            img,
            new String(byteFilter),
            Integer.parseInt(author),
            name,
            desc
        );

        uof.addRecipesToBook(_id, ids);

        Map<String, Object> map = new HashMap<String, Object>();

        //email approvement!
        logger.info("Cookbook Edited");
        map.put("success", true);
        map.put("id", _id);
        return map;
    }

    @PostMapping(path = "/editRecipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    @ResponseBody
    public Map<String, Object> newRecipe(
            @RequestParam("image") Object image,
            @RequestParam("_id") String _id,
            @RequestParam("author") String author,
            @RequestParam("name") String name,
            @RequestParam("desc") String desc,
            @RequestParam("creationDate") String creationDate,
            @RequestParam("directions") String directions,
            @RequestParam("cookTime") Integer cookTime,
            @RequestParam("ingredients") String ingredients
    ) throws IOException {
        String img = "";
        if(image.getClass().equals(String.class)){
            img = image.toString();
        }
        if(image.getClass().equals(MultipartFile.class)){
            MultipartFile fileImage = (MultipartFile) image;
            File conver = new File("/Users/selevn/3kurs/Ptsei/files/"+fileImage.getOriginalFilename());
            conver.createNewFile();
            try (FileOutputStream fout = new FileOutputStream(conver)){
                fout.write(fileImage.getBytes());
            } catch (Exception e){
                e.printStackTrace();
            }
            CloudinaryUploadService service = CloudinaryUploadService.getInstance();
            //todo: change on update
            CloudinaryOutput data = service.loadImage("/Users/selevn/3kurs/Ptsei/files/"+fileImage.getOriginalFilename());
            img = data.getUrl();

        }
        var intId = Integer.parseInt(_id);
        var id = uof.editRecipe(
                intId,
                img,
                cookTime,
                Integer.parseInt(author),
                name,
                desc,
                directions,
                ingredients
        );


        Map<String, Object> map = new HashMap<String, Object>();

        //email approvement!
        logger.info("Recipe Edited");

        map.put("success", true);
        map.put("id", intId);
        return map;
    }
}


