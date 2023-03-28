package com.training.spring.bays.di.hello;

public class ConfGreeting implements IGreetings {

    private final String helloPrefix;
    private final String goodbyePrefix;

    public ConfGreeting(final String helloPrefixParam,
                        final String goodbyePrefixParam) {
        super();
        this.helloPrefix = helloPrefixParam;
        this.goodbyePrefix = goodbyePrefixParam;
    }

    @Override
    public String sayHello(final String nameParam,
                           final String surnameParam) {
        return this.helloPrefix + " " + nameParam + " " + surnameParam;
    }

    @Override
    public String sayGoodBye(final String nameParam,
                             final String surnameParam) {
        return this.goodbyePrefix + " " + nameParam + " " + surnameParam;
    }

}
