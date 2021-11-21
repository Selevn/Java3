package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.CookbooksViewEntity;
import com.selevn.demo.entities.RecipesViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


public interface CookBooksRepository extends JpaRepository<CookbooksViewEntity, Integer>{
    @Query(value = "select * from get_cookbooks(?1,?2,?3,CAST(?4 as varbit),?5,CAST(?6 as varchar))", nativeQuery = true)
    List<CookbooksViewEntity> getAll(Integer count,
                                     Integer page,
                                     Integer sortby,
                                     String filter,
                                     Integer hidemy,
                                     String searchString);
    @Query(value = "select * from get_cookbooks(?1,?2,?3,null,?4,CAST(?5 as varchar))", nativeQuery = true)
    List<CookbooksViewEntity> getAllNoFilters(Integer count,
                                     Integer page,
                                     Integer sortby,
                                     Integer hidemy,
                                     String searchString);

    @Query(value = "select * from get_cookbooks_count(?1,?2,?3,CAST(?4 as varbit),?5,CAST(?6 as varchar))", nativeQuery = true)
    int getAllCount(Integer count,
                                     Integer page,
                                     Integer sortby,
                                     String filter,
                                     Integer hidemy,
                                     String searchString);
    @Query(value = "select * from get_cookbooks_count(?1,?2,?3,null,?4,CAST(?5 as varchar))", nativeQuery = true)
    int getAllNoFiltersCount(Integer count,
                                              Integer page,
                                              Integer sortby,
                                              Integer hidemy,
                                              String searchString);

    @Query(value = "select * from get_user_cookbooks(?1,?2,?3)", nativeQuery = true)
    List<CookbooksViewEntity> getUserCookBooks(Integer id,
                                               Integer count,
                                               Integer page);
    @Query(value = "select * from get_user_cookbooks_count(?1,?2,?3)", nativeQuery = true)
    int getUserCookBooksCount(Integer id,
                              Integer count,
                              Integer page);


    @Query(value = "select * from get_user_liked_cookbooks(?1,?2,?3)", nativeQuery = true)
    List<CookbooksViewEntity> getUserLikedCookBooks(Integer id,
                                               Integer count,
                                               Integer page);
    @Query(value = "select * from get_user_liked_cookbooks_count(?1,?2,?3)", nativeQuery = true)
    int getUserLikedCookBooksCount(Integer id,
                              Integer count,
                              Integer page);
    @Transactional
    @Modifying
    @Query(value = "call like_cookbook(?1,?2)", nativeQuery = true)
    void likeCookBook(Integer userId,
                      Integer bookId);

    @Transactional
    @Modifying
    @Query(value = "call visit_cookbook(?1)", nativeQuery = true)
    void visitCookBook(Integer cookbookId);

    @Query(value = "select * from get_cookbooks_count()", nativeQuery = true)
    int getTotalCookBooksCount();

    @Query(value = "select * from get_all_user_liked_cookbooks(?1)", nativeQuery = true)
    List<CookbooksViewEntity> getAllUserLikedCookbooks(Integer userid);

    @Query(value = "select * from create_cookbook(?1,?2,CAST(?3 as varbit),?4,?5,?6,?7)", nativeQuery = true)
    int createCookbook(
            Integer views,
            String image,
            String filters,
            Date creation_date,
            Integer author,
            String name,
            String desc
    );

    @Transactional
    @Modifying
    @Query(value = "call add_recipes_to_cookbook(?1, CAST(?2 as integer[]))", nativeQuery = true)
    void addRecipesToCookbook(
            Integer book,
            String recipes
    );
}
