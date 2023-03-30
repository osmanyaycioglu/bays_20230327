package com.training.spring.bays.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsStrImpl implements ConstraintValidator<NotContainsStr, String> {

    private NotContainsStr anno;

    @Override
    public void initialize(final NotContainsStr anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        String[] valueLoc = this.anno.value();
        for (String stringLoc : valueLoc) {
            if (valueParam.contains(stringLoc)) {
                return false;
            }
        }
        return true;
    }

}
