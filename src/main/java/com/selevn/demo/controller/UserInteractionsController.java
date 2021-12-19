package com.selevn.demo.controller;

import com.selevn.demo.controller.userInput.CreateComment;
import com.selevn.demo.controller.userInput.LikeItem;
import com.selevn.demo.controller.userInput.VisitItem;
import com.selevn.demo.controller.userOutput.SuccessResult;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.exceptions.ApiRequestException;
import com.selevn.demo.utils.TypeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/userInteractions",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserInteractionsController {

    Logger logger = LoggerFactory.getLogger(UserInteractionsController.class);

    @Autowired
    private UOF uof;

    @PostMapping(value = {"/likeCookBook"})
    @ResponseBody
    public SuccessResult likeCookBook(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Like cookbook",
                    required = true
            )
            @RequestBody LikeItem item
    ) {
        var likeResult = uof.likeCookBook(
                item.getFrom(),
                item.getTo());

        logger.info("likeCookBook success "+likeResult);
        return new SuccessResult(likeResult);
    }

    @PostMapping(value = {"/likeRecipe"})
    @ResponseBody
    public SuccessResult likeRecipe(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Like recipe",
                    required = true
            )
            @RequestBody LikeItem item
    ) {
        var likeResult = uof.likeRecipe(
               item.getFrom(),
                item.getTo());

        logger.info("likeRecipe success "+likeResult);
        return new SuccessResult(likeResult);
    }
    @PostMapping(value = {"/visitItem"})
    @ResponseBody
    public SuccessResult visitItem(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Item to visit",
                    required = true
            )
                    @RequestBody @Valid VisitItem item, BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            for (Object object : bindingResult.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    logger.info(fieldError.getCode());

                    throw new ApiRequestException(fieldError.getDefaultMessage());
                }

                if(object instanceof ObjectError) {
                    ObjectError objectError = (ObjectError) object;
                    logger.info(objectError.getCode());
                    throw new ApiRequestException(objectError.getDefaultMessage());
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();

        var visitResult = uof.visitItem(
                item.getTo(),
                item.getTypeParsed()
        );
        logger.info("visitItem success "+visitResult);

        return new SuccessResult(visitResult);
    }

    @PostMapping(value = {"/comment"})
    @ResponseBody
    public SuccessResult comment(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Item to comment",
                    required = true
            )
            @RequestBody CreateComment item
    ) {
        var result= uof.addComment(
                item.parseType(),
                item.getAuthor(),
                item.getItemId(),
                item.getText()
        );
        logger.info("comment success "+result);
        return new SuccessResult(result);
    }
}
