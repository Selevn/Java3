package com.selevn.demo.BLL.domains.modules.entities.Repositories;

import com.selevn.demo.BLL.domains.modules.entities.RecipeORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeORMRepository extends JpaRepository<RecipeORM, Integer> {
}