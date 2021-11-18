package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.RecipesViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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


}
