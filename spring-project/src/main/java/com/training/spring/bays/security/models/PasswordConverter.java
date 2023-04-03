package com.training.spring.bays.security.models;

import com.training.spring.bays.security.JasyptSec;

import jakarta.persistence.AttributeConverter;

public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(final String attributeParam) {
        return JasyptSec.defaultEnc.encrypt(attributeParam);
    }

    @Override
    public String convertToEntityAttribute(final String dbDataParam) {
        System.out.println(dbDataParam);
        return JasyptSec.defaultEnc.decrypt(dbDataParam);
    }

}
