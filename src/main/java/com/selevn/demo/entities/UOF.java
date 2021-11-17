package com.selevn.demo.entities;


import com.selevn.demo.entities.repositories.RecipesRepository;
import com.selevn.demo.entities.repositories.CookBooksRepository;
import com.selevn.demo.entities.repositories.SingleRecipeRepository;
import com.selevn.demo.entities.wrapper.EntityWrapper;
import com.selevn.demo.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UOF {
    @Autowired
    private CookBooksRepository cookBooksRepository;
    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private SingleRecipeRepository singleRecipeRepository;


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


        recipes.total = recipesRepository.getAllCount(15, page, sortby, cookTime, hidemy, searchString);
        recipes.docs = recipesRepository.getAll(15, page, sortby, cookTime, hidemy, searchString);

        recipes.hasNext = Pager.hasNext(page,recipes.total);
        recipes.nextPage = page+2;
        return recipes;
    }

    public SingleRecipeViewEntity getSingleRecipe(Integer id){
        return singleRecipeRepository.getSingleRecipeViewEntityById(id);
    }
}
