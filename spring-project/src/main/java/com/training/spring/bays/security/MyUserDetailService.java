package com.training.spring.bays.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.training.spring.bays.security.models.IUserDao;
import com.training.spring.bays.security.models.User;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDao              userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(final String usernameParam) throws UsernameNotFoundException {
        User findByUsernameLoc = this.userDao.findByUsername(usernameParam);
        if (findByUsernameLoc == null) {
            throw new UsernameNotFoundException("Böyle bir user yok");
        }
        return org.springframework.security.core.userdetails.User.builder()
                                                                 .username(usernameParam)
                                                                 .password(this.encoder.encode(findByUsernameLoc.getPassword()))
                                                                 .roles(findByUsernameLoc.getRole())
                                                                 .build();
    }

}
