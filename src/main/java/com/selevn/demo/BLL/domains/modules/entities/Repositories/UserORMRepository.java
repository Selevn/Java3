package com.selevn.demo.BLL.domains.modules.entities.Repositories;

import com.selevn.demo.BLL.domains.modules.entities.UserORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserORMRepository extends JpaRepository<UserORM, Integer> {

}