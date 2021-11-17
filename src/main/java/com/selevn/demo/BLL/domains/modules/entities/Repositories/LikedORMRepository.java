package com.selevn.demo.BLL.domains.modules.entities.Repositories;

import com.selevn.demo.BLL.domains.modules.entities.LikedORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedORMRepository extends JpaRepository<LikedORM, Integer> {
}