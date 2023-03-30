package com.training.spring.bays.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartwithImpl implements ConstraintValidator<Startwith, String> {

    private Startwith anno;

    @Override
    public void initialize(final Startwith anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.anno.value());
    }

}
