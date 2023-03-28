package com.training.spring.bays.di;

import org.springframework.stereotype.Component;

@Component
public class TotalExecutor implements IExecute {

    @Override
    public String exec(final String strParam,
                       final int countParam) {
        return "Executed " + strParam + " count : " + countParam;
    }

    public void extraMethod() {
        System.out.println("Extra method");
    }
}
