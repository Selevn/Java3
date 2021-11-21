package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.CommentsViewEntity;
import com.selevn.demo.entities.UserNoPrivateViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<UserNoPrivateViewEntity, Integer>{
    UserNoPrivateViewEntity getUserNoPrivateViewEntityById(Integer id);

    @Query(value = "select * from get_users_count()", nativeQuery = true)
    int getTotalUsersCount();


    @Query(value = "select * from create_user('Valar','Morgulius',?1,'',?2,?3,'')", nativeQuery = true)
    int createUser(String email, String password, String salt);
}
