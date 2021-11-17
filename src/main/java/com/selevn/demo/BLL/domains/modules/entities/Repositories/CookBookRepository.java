package com.selevn.demo.BLL.domains.modules.entities.Repositories;

import com.selevn.demo.BLL.domains.modules.entities.CookbookORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookBookRepository extends JpaRepository<CookbookORM, Integer> {
    CookbookORM getCookBookById(Integer id);
}
