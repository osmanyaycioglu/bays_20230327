package com.training.spring.bays.conf;

class Connection {

    private final String host;
    private final String name;
    private final int    port;

    private Connection(final String hostParam,
                       final String nameParam,
                       final int portParam) {
        super();
        this.host = hostParam;
        this.name = nameParam;
        this.port = portParam;
    }

    public String getHost() {
        return this.host;
    }

    public String getName() {
        return this.name;
    }

    public int getPort() {
        return this.port;
    }

    public static ConnectionBuilder getBuilder() {
        return new ConnectionBuilder();
    }

    public static class ConnectionBuilder {

        private String host;
        private String name;
        private int    port;

        private ConnectionBuilder() {
        }

        public String getHost() {
            return this.host;
        }

        public ConnectionBuilder setHost(final String hostParam) {
            this.host = hostParam;
            return this;
        }

        public String getName() {
            return this.name;
        }

        public ConnectionBuilder setName(final String nameParam) {
            this.name = nameParam;
            return this;
        }

        public int getPort() {
            return this.port;
        }

        public ConnectionBuilder setPort(final int portParam) {
            this.port = portParam;
            return this;
        }

        public Connection build() {
            return new Connection(this.host,
                                  this.name,
                                  this.port);
        }

    }
}
