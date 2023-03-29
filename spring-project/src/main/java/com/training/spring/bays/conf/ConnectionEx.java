package com.training.spring.bays.conf;

import lombok.Builder;

public class ConnectionEx {

    private final String host;
    private final String name;
    private final int    port;

    @Builder(setterPrefix = "with")
    public ConnectionEx(final String host,
                        final String name,
                        final int port) {
        super();
        this.host = host;
        this.name = name;
        this.port = port;
    }
}
