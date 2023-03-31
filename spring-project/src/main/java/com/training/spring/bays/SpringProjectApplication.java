package com.training.spring.bays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.training.spring.bays.java.Car;
import com.training.spring.bays.java.CarCache;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.spring.bays",
//                                            "com.spring.bays"
//})
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.training.spring.bays.employee.mongo")
@EnableJpaRepositories(basePackages = "com.training.spring.bays.employee.data")
public class SpringProjectApplication {

    private final CarCache carCache;

    @Autowired
    public SpringProjectApplication(final CarCache carCacheParam) {
        super();
        this.carCache = carCacheParam;
    }

    public void doSomething() {
        System.out.println("adding car");
        Car carLoc = new Car(100,
                             "Ford");
        this.carCache.addCar(carLoc);
    }

    public static void main(final String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringProjectApplication.class,
                                                                          args);
        //        SpringProjectApplication beanLoc = contextLoc.getBean(SpringProjectApplication.class);
        //        beanLoc.doSomething();

        //        SpringProjectApplication applicationLoc = new SpringProjectApplication();
        //        applicationLoc.doSomething();
    }

}
