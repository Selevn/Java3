package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.SingleCookbookViewEntity;
import com.selevn.demo.entities.SingleRecipeViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SingleCookBookRepository extends JpaRepository<SingleCookbookViewEntity, Integer> {
    @Query(value = "select * from get_cookbook(?1)", nativeQuery = true)
    SingleCookbookViewEntity getSingleCookbookViewEntityById(Integer id);
}
