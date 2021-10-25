package com.selevn.demo.entities;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceTest {

    @Autowired
    private UserService service;

    @AfterEach
    void tearDown() {

    }
    @Test
    public void getAllUsers() {
        User user = service.getById(3);

        Assert.assertEquals(java.util.Optional.of(user.getId()), java.util.Optional.of(3L));
        Assert.assertNotNull(user.getFirstName());
    }


}