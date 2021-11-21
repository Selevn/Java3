package com.selevn.demo.Service;

import com.selevn.demo.entities.SingleUserEntity;
import com.selevn.demo.entities.UOF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    final private UOF uof;

    public UserService() {
        uof = null;
    }


    @Override
    public SingleUserEntity loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = uof.getUserForLogin(email);
        return user;
    }

}
