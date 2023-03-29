package com.training.spring.bays.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.spring.bays.di.hello.ConfGreeting;
import com.training.spring.bays.di.hello.IGreetings;

@Profile("live")
@Configuration
public class LiveConfig {

    @Bean
    public IGreetings greetingsBean(@Value("${greets.hello.prefix}") final String helloPrefix,
                                    @Value("${greets.goodbye.prefix}") final String goodbyePrefix) {
        return new ConfGreeting(helloPrefix,
                                goodbyePrefix);
    }

}
