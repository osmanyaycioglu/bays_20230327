package com.training.spring.bays.di.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@RestController
//@Repository
//@Service

@Configuration
public class HelloConfiguration {

    //    @Autowired
    //    private Environment environment;

    @Bean
    public IGreetings createDynamicGreet(@Value("${greets.hello.prefix}") final String helloPrefix,
                                         @Value("${greets.goodbye.prefix}") final String goodbyePrefix) {
        return new ConfGreeting(helloPrefix,
                                goodbyePrefix);
    }

    @Bean
    public IGreetings createDynamicGreetOld(final Environment environment) {
        String helloPrefix = environment.getProperty("greets.hello.prefix");
        String goodbyePrefix = environment.getProperty("greets.goodbye.prefix");
        return new ConfGreeting(helloPrefix,
                                goodbyePrefix);
    }

    @Bean("conf-tr-greet")
    public IGreetings createTrGreet() {
        GreetingsImpl greetingsImplLoc = new GreetingsImpl();
        greetingsImplLoc.toString();
        return greetingsImplLoc;
    }

    @Bean
    public IGreetings createEspGreet() {
        return new GreetingsEspImpl();
    }

    @Bean
    public IGreetings createEnConfigGreet() {
        return new ConfGreeting("Hello",
                                "Goodbye");
    }

    @Bean
    public IGreetings createJpConfigGreet() {
        return new ConfGreeting("Aha",
                                "Maha");
    }

}
