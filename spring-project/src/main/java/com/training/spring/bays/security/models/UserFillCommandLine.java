package com.training.spring.bays.security.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.training.spring.bays.security.JWTService;

@Component
public class UserFillCommandLine implements CommandLineRunner {

    @Autowired
    private IUserDao   userDao;

    @Autowired
    private JWTService jwtService;

    @Override
    public void run(final String... argsParam) throws Exception {
        User findByUsernameLoc = this.userDao.findByUsername("superadmin");
        if (findByUsernameLoc == null) {
            findByUsernameLoc = new User();
            findByUsernameLoc.setUsername("superadmin");
            findByUsernameLoc.setPassword("123456");
            findByUsernameLoc.setRole("ADMIN");
            this.userDao.save(findByUsernameLoc);
        }
    }

}
