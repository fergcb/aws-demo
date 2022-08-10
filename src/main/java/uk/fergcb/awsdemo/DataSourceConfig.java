package uk.fergcb.awsdemo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

        String hostName = envOr("RDS_HOSTNAME", "localhost");
        String port = envOr("RDS_PORT", "3306");
        String dbName = envOr("RDS_DB_NAME", "ebdb");
        String username = envOr("RDS_USERNAME", "root");
        String password = envOr("RDS_PASSWORD", "root");

        String url = String.format("jdbc:mysql://%s:%s/%s", hostName, port, dbName);

        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);

        System.out.printf("Using data source config:%n  url=%s%n  username=%s%n  password=%s%n", url, username, password);

        return dataSourceBuilder.build();
    }

    private String envOr(String key, String fallback) {
        String value = System.getenv(key);
        return value != null ? value : fallback;
    }
}