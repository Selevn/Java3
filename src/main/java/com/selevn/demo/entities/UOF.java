package com.selevn.demo.entities;


import com.selevn.demo.entities.repositories.*;
import com.selevn.demo.entities.wrapper.EntityWrapper;
import com.selevn.demo.utils.ItemType;
import com.selevn.demo.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UOF {
    @Autowired
    private CookBooksRepository cookBooksRepository;
    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private SingleRecipeRepository singleRecipeRepository;
    @Autowired
    private SingleCookBookRepository singleCookBookRepository;
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SingleUserEntityRepository singleUserEntityRepository;


    public EntityWrapper<CookbooksViewEntity> getCookBooks(Integer page,
                                            Integer sortby,
                                            Boolean vegeterian,
                                            Boolean noMilk,
                                            Boolean noEggs,
                                            Integer hidemy,
                                            String searchString) {
        EntityWrapper<CookbooksViewEntity> books = new EntityWrapper<CookbooksViewEntity>();
        if(page == null)
            page = 0;
        if(sortby == null)
            sortby = 0;
        if(hidemy == null)
            hidemy = -1;

        if(searchString == null)
            searchString = "";

        StringBuilder filters = new StringBuilder();

        filters.append('b');

        if(vegeterian == null || vegeterian == false)
            filters.append(0);
        else
            filters.append(1);
        if(noMilk == null || noMilk == false)
            filters.append(0);
        else
            filters.append(1);
        if(noEggs == null || noEggs == false)
            filters.append(0);
        else
            filters.append(1);
        if(filters.toString().equals("b000")) {
            books.docs = cookBooksRepository.getAllNoFilters(15, page, sortby, hidemy, searchString);
            books.total = cookBooksRepository.getAllNoFiltersCount(15, page, sortby, hidemy, searchString);
        }
        else {
            books.total = cookBooksRepository.getAllCount(15, page, sortby, filters.toString(), hidemy, searchString);
            books.docs = cookBooksRepository.getAll(15, page, sortby, filters.toString(), hidemy, searchString);
        }
        books.hasNext = Pager.hasNext(page,books.total);
        books.nextPage = page+2;
        return books;
    }
    public EntityWrapper<CookbooksViewEntity> getCookBooks() {
        return this.getCookBooks(0,0, null,null,null, -1, "");
    }




    public EntityWrapper<RecipesViewEntity> getRecipes(Integer page,
                                            Integer sortby,
                                            Integer cookTime,
                                            Integer hidemy,
                                            String searchString) {
        EntityWrapper<RecipesViewEntity> recipes = new EntityWrapper<RecipesViewEntity>();
        if(page == null)
            page = 0;
        if(sortby == null)
            sortby = 0;
        if(hidemy == null)
            hidemy = -1;

        if(searchString == null)
            searchString = "";
        if(cookTime == null)
            cookTime = 1000;

        recipes.total = recipesRepository.getAllCount(15, page, sortby, cookTime, hidemy, searchString);
        recipes.docs = recipesRepository.getAll(15, page, sortby, cookTime, hidemy, searchString);

        recipes.hasNext = Pager.hasNext(page,recipes.total);
        recipes.nextPage = page+2;
        return recipes;
    }
    public EntityWrapper<RecipesViewEntity> getRecipesByCookBook(Integer page,
                                                                 Integer cookbookId) {
        EntityWrapper<RecipesViewEntity> recipes = new EntityWrapper<RecipesViewEntity>();
        if(page == null)
            page = 0;

        recipes.total = recipesRepository.getRecipesByCookBookCount(cookbookId,15, page);
        recipes.docs = recipesRepository.getRecipesByCookBook(cookbookId,15, page);

        recipes.hasNext = Pager.hasNext(page,recipes.total);
        recipes.nextPage = page+2;
        return recipes;
    }

    public SingleRecipeViewEntity getSingleRecipe(Integer id){
        return singleRecipeRepository.getSingleRecipeViewEntityById(id);
    }

    public SingleCookbookViewEntity getSingleCookBook(Integer id){
        return singleCookBookRepository.getSingleCookbookViewEntityById(id);
    }
    public EntityWrapper<CommentsViewEntity> getComments(Integer id,
                                                         Integer type,
                                                         Integer page){
        var comments = new EntityWrapper<CommentsViewEntity>();
        comments.docs = commentsRepository.getComments(id,type,15,page);
        comments.total = commentsRepository.getCommentsCount(id,type);
        comments.hasNext = Pager.hasNext(page,comments.total);
        comments.nextPage = page+2;
        return comments;
    }
    public UserNoPrivateViewEntity getUser(Integer id){
        return userRepository.getUserNoPrivateViewEntityById(id);
    }
    public EntityWrapper<CookbooksViewEntity> getUserCookBooks(Integer id, Integer page){
        EntityWrapper<CookbooksViewEntity> books = new EntityWrapper<CookbooksViewEntity>();
        books.total = cookBooksRepository.getUserCookBooksCount(id,15, page);
        books.docs = cookBooksRepository.getUserCookBooks(id,15, page);

        books.hasNext = Pager.hasNext(page,books.total);
        books.nextPage = page+2;
        return books;
    }
    public EntityWrapper<CookbooksViewEntity> getUserLikedCookBooks(Integer id, Integer page){
            EntityWrapper<CookbooksViewEntity> books = new EntityWrapper<CookbooksViewEntity>();
            books.total = cookBooksRepository.getUserLikedCookBooksCount(id,15, page);
            books.docs = cookBooksRepository.getUserLikedCookBooks(id,15, page);

            books.hasNext = Pager.hasNext(page,books.total);
            books.nextPage = page+2;
            return books;
        }

    public EntityWrapper<RecipesViewEntity> getUserRecipes(Integer id, Integer page){
        EntityWrapper<RecipesViewEntity> recipes = new EntityWrapper<RecipesViewEntity>();
        recipes.total = recipesRepository.getUserRecipesCount(id,15, page);
        recipes.docs = recipesRepository.getUserRecipes(id,15, page);

        recipes.hasNext = Pager.hasNext(page,recipes.total);
        recipes.nextPage = page+2;
        return recipes;
    }
    public EntityWrapper<RecipesViewEntity> getUserLikedRecipes(Integer id, Integer page){
        EntityWrapper<RecipesViewEntity> recipes = new EntityWrapper<RecipesViewEntity>();
        recipes.total = recipesRepository.getUserLikedRecipesCount(id,15, page);
        recipes.docs = recipesRepository.getUserLikedRecipes(id,15, page);
        recipes.hasNext = Pager.hasNext(page,recipes.total);
        recipes.nextPage = page+2;
        return recipes;
    }

    public boolean likeCookBook(Integer userId, Integer bookId){
        try{
            cookBooksRepository.likeCookBook(userId,bookId);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean likeRecipe(Integer userId, Integer recipeId){
        try{
            recipesRepository.likeRecipe(userId,recipeId);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean visitItem(Integer itemId, Integer type){
        try{
        if(type == 0)
            recipesRepository.visitRecipe(itemId);
        if(type != 0)
            cookBooksRepository.visitCookBook(itemId);
        return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public int getTotalUsersCount(){
        return userRepository.getTotalUsersCount();
    }
    public int getTotalRecipesCount(){
        return recipesRepository.getTotalRecipesCount();
    }
    public int getTotalCookBooksCount(){
        return cookBooksRepository.getTotalCookBooksCount();
    }
    public SingleUserEntity getUserForLogin(String email){
        return singleUserEntityRepository.getSingleUserEntityByEmail(email);
    }
    public List<Integer> getAllUserLikedRecipesIds(Integer id){
        return recipesRepository.getAllUserLikedRecipes(id).stream().map(RecipesViewEntity::getId).collect(Collectors.toList());
    }
    public List<Integer> getAllUserLikedCookBooksIds(Integer id){
        return cookBooksRepository.getAllUserLikedCookbooks(id).stream().map(CookbooksViewEntity::getId).collect(Collectors.toList());
    }
    public boolean addComment(Integer type, Integer userId, Integer itemId, String text){
        if(type == ItemType.RECIPE.getNumVal())
        {
            commentsRepository.addRecipeComment(userId,itemId,new Date(),text);
        } else if(type == ItemType.COOKBOOK.getNumVal()){
            commentsRepository.addCookBookComment(userId,itemId,new Date(),text);
        }
        return true;
    }
}
