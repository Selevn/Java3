package com.selevn.demo.BLL.domains.modules.entities.Repositories;

import com.selevn.demo.BLL.domains.modules.entities.CommentORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentORMRepository extends JpaRepository<CommentORM, Integer> {
}