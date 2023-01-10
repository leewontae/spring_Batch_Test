package com.example.Spring_Batch_Test.querydsl.PGIS;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.Spring_Batch_Test.querydsl.PGIS",//레파지토리 패키지 경로
    entityManagerFactoryRef = "PGISEntityManager",
    transactionManagerRef = "PGISTransactionManager")
public class PGISConfig {

    @Bean
    @Primary //Master가 되는 Datasource를 지정해야 한다.
    @ConfigurationProperties(prefix = "spring.pgis-datasource")
    public DataSource PGISDataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean PGISEntityManager() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(PGISDataSource());
        em.setPackagesToScan("com.example.Spring_Batch_Test.querydsl.PGIS"); //엔티티 패키지 경로
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaPropertyMap(new HashMap<String, Object>() {{
            put("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisDialect");
        }});

        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager PGISTransactionManager() {

        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(PGISEntityManager().getObject());

        return tm;
    }
}