public class PoolConfig {

    private final String jdbcUrl;
    private final String username;
    private final String password;
    private final int maxPoolSize;
    private final int minIdle;
    private final long connectionTimeoutMs;

    private PoolConfig(Builder builder) {
        this.jdbcUrl            = builder.jdbcUrl;
        this.username           = builder.username;
        this.password           = builder.password;
        this.maxPoolSize        = builder.maxPoolSize;
        this.minIdle            = builder.minIdle;
        this.connectionTimeoutMs = builder.connectionTimeoutMs;
    }

    public String getJdbcUrl()           { return jdbcUrl; }
    public String getUsername()          { return username; }
    public String getPassword()          { return password; }
    public int getMaxPoolSize()          { return maxPoolSize; }
    public int getMinIdle()              { return minIdle; }
    public long getConnectionTimeoutMs() { return connectionTimeoutMs; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String jdbcUrl;
        private String username;
        private String password;
        private int maxPoolSize         = 10;
        private int minIdle             = 2;
        private long connectionTimeoutMs = 3000;

        public Builder jdbcUrl(String val)           { this.jdbcUrl = val; return this; }
        public Builder username(String val)          { this.username = val; return this; }
        public Builder password(String val)          { this.password = val; return this; }
        public Builder maxPoolSize(int val)          { this.maxPoolSize = val; return this; }
        public Builder minIdle(int val)              { this.minIdle = val; return this; }
        public Builder connectionTimeoutMs(long val) { this.connectionTimeoutMs = val; return this; }

        public PoolConfig build() {
            if (jdbcUrl == null || jdbcUrl.isEmpty())
                throw new IllegalArgumentException("jdbcUrl is required");
            if (maxPoolSize < 1)
                throw new IllegalArgumentException("maxPoolSize must be at least 1");
            if (minIdle > maxPoolSize)
                throw new IllegalArgumentException("minIdle cannot exceed maxPoolSize");
            return new PoolConfig(this);
        }
    }

    @Override
    public String toString() {
        return "PoolConfig{jdbcUrl='" + jdbcUrl + "', maxPoolSize=" + maxPoolSize
                + ", minIdle=" + minIdle + ", timeoutMs=" + connectionTimeoutMs + "}";
    }
}
