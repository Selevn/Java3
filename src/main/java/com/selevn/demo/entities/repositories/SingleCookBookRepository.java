package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.SingleCookbookViewEntity;
import com.selevn.demo.entities.SingleRecipeViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleCookBookRepository extends JpaRepository<SingleCookbookViewEntity, Integer> {
    SingleCookbookViewEntity getSingleCookbookViewEntityById(Integer id);
}
