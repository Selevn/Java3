package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.CommentsViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface CommentsRepository extends JpaRepository<CommentsViewEntity, Integer>{
    @Query(value = "select * from get_comments(?1,?2,?3,?4)", nativeQuery = true)
    List<CommentsViewEntity> getComments(Integer id,
                                       Integer type,
                                       Integer count,
                                       Integer page);
    @Query(value = "select * from get_comments_count(?1,?2)", nativeQuery = true)
    int getCommentsCount(Integer id,
                         Integer type);

    @Query(value = "select * from add_comment(?1,?2,-1,?3,?4)", nativeQuery = true)
    void addRecipeComment(Integer userId,
                         Integer itemId,
                         Date date,
                         String text
    );
    @Query(value = "select * from add_comment(?1,-1,?2,?3,?4)", nativeQuery = true)
    void addCookBookComment(Integer userId,
                           Integer itemId,
                           Date date,
                           String text);

}
