package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.SingleRecipeViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SingleRecipeRepository extends JpaRepository<SingleRecipeViewEntity, Integer> {
    SingleRecipeViewEntity getSingleRecipeViewEntityById(Integer id);
}
