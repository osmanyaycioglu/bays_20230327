package com.training.spring.bays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.training.spring.bays.di.IExecute;

@Component
public class ApplicationRun implements ApplicationRunner {

    // Field Injection
    @Autowired
    private SpringProjectApplication projectApplication;
    private Environment              environment;
    private final ApplicationContext applicationContext;
    @Autowired
    private IExecute                 totalExecutor;

    // Constructor Injection
    @Autowired
    public ApplicationRun(final ApplicationContext applicationContextParam) {
        super();
        this.applicationContext = applicationContextParam;
    }

    // Method Injection
    @Autowired
    public void setEnv(final Environment environmentParam) {
        this.environment = environmentParam;
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        this.projectApplication.doSomething();
        String execLoc = this.totalExecutor.exec("exec1",
                                                 3);
        System.out.println(execLoc);
        String propertyLoc = this.environment.getProperty("app.calc.add.value1");
        int addvalue1 = Integer.parseInt(propertyLoc);

    }

}
