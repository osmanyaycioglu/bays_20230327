package com.training.spring.bays.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target({
          TYPE,
          FIELD,
          METHOD
})
@Constraint(validatedBy = {
                            ContainsStrImpl.class
})
public @interface NotContainsStr {

    String[] value();

    String message() default "{jakarta.validation.constraints.ContainsStr.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
