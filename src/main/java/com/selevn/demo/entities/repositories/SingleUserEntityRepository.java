package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.SingleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SingleUserEntityRepository extends JpaRepository<SingleUserEntity, Integer>{
        SingleUserEntity getSingleUserEntityByEmail(String email);

}
