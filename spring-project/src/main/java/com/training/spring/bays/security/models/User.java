package com.training.spring.bays.security.models;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "secret")
public class User {

    @Id
    @GeneratedValue
    private Long   userId;
    @Column(unique = true)
    private String username;
    @Convert(converter = PasswordConverter.class)
    private String password;
    private String role;

}
