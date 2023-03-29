package com.training.spring.bays.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.spring.bays.di.hello.GreetingsImpl;
import com.training.spring.bays.di.hello.IGreetings;

@Profile("dev")
@Configuration
public class DevConfig {

    @Bean
    public IGreetings greetingsBean() {
        return new GreetingsImpl();
    }

}
