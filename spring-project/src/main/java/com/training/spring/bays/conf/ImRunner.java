package com.training.spring.bays.conf;

import java.math.BigDecimal;

public class ImRunner {

    public static void main(final String[] args) {
        Integer aIntegerLoc = 10;
        aIntegerLoc += 100;

        String stringLoc = "osman";
        String concatLoc = stringLoc.concat(" yaycıoğlu");

        BigDecimal bigDecimalLoc = BigDecimal.TEN;

        Connection buildLoc = Connection.getBuilder()
                                        .setName("con1")
                                        .setHost("127.0.0.1")
                                        .setPort(9090)
                                        .build();

        ConnectionEx connectionExLoc = ConnectionEx.builder()
                                                   .withName("con1")
                                                   .withHost("127.0.0.1")
                                                   .withPort(9090)
                                                   .build();

    }
}
