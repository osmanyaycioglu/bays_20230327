package com.training.spring.bays.security.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
