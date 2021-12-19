package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.RecipesViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


public interface RecipesRepository extends JpaRepository<RecipesViewEntity, Integer>{
    @Query(value = "select * from get_recipes(?1,?2,?3,?4,?5,CAST(?6 as varchar))", nativeQuery = true)
    List<RecipesViewEntity> getAll(Integer count,
                                   Integer page,
                                   Integer sortby,
                                   Integer cookTime,
                                   Integer hidemy,
                                   String searchString);

    @Query(value = "select * from get_recipes_count(?1,?2,?3,?4,?5,CAST(?6 as varchar))", nativeQuery = true)
    int getAllCount(Integer count,
                    Integer page,
                    Integer sortby,
                    Integer cookTime,
                    Integer hidemy,
                    String searchString);


    @Query(value = "select * from get_user_recipes(?1,?2,?3)", nativeQuery = true)
    List<RecipesViewEntity> getUserRecipes(Integer id,
                                   Integer count,
                                   Integer page);

    @Query(value = "select * from get_user_recipes_count(?1,?2,?3)", nativeQuery = true)
    int getUserRecipesCount(Integer id,
                    Integer count,
                    Integer page);

    @Query(value = "select * from get_user_liked_recipes(?1,?2,?3)", nativeQuery = true)
    List<RecipesViewEntity> getUserLikedRecipes(Integer id,
                                   Integer count,
                                   Integer page);

    @Query(value = "select * from get_user_liked_recipes_count(?1,?2,?3)", nativeQuery = true)
    int getUserLikedRecipesCount(Integer id,
                    Integer count,
                    Integer page);

    @Query(value = "select * from get_recipes_by_cookbook(?3,?2,?1)", nativeQuery = true)
    List<RecipesViewEntity> getRecipesByCookBook(Integer id,
                                                Integer count,
                                                Integer page);

    @Query(value = "select * from get_recipes_by_cookbook_count(?3,?2,?1)", nativeQuery = true)
    int getRecipesByCookBookCount(Integer id,
                                 Integer count,
                                 Integer page);

    @Transactional
    @Modifying
    @Query(value = "call like_recipe(?1,?2)", nativeQuery = true)
    void likeRecipe(Integer userId,
                    Integer recipeId);

    @Transactional
    @Modifying
    @Query(value = "call visit_recipe(?1)", nativeQuery = true)
    void visitRecipe(Integer recipeId);

    @Query(value = "select * from get_total_recipes_count()", nativeQuery = true)
    int getTotalRecipesCount();

    @Query(value = "select * from get_all_user_liked_recipes(?1)", nativeQuery = true)
    List<RecipesViewEntity> getAllUserLikedRecipes(Integer userid);

    //create_recipe(integer, character varying, integer, unknown, integer, character varying, character varying, character varying, character varying)
    @Query(value = "select * from create_recipe(?1,?2,?3,CAST(?4 as date),?5,?6,?7,CAST(?8 as json),CAST(?9 as json))", nativeQuery = true)
    int createRecipe(
            Integer views,
            String image,
            Integer cookTime,
            Date creation_date,
            Integer author,
            String name,
            String desc,
            String _ingredients,
            String _directions
    );

    @Transactional
    @Modifying
    @Query(value = "call update_recipe(?1,?2,?3,?4,?5,?6,CAST(?7 as json),CAST(?8 as json))", nativeQuery = true)
    int editRecipe(
            Integer id,
            String image,
            Integer cookTime,
            Integer author,
            String name,
            String desc,
            String _ingredients,
            String _directions
    );
}
