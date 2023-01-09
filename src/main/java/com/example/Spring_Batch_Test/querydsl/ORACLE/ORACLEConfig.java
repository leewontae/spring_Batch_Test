package com.example.Spring_Batch_Test.querydsl.ORACLE;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.Spring_Batch_Test.querydsl.ORACLE",//레파지토리 패키지 경로
        entityManagerFactoryRef = "ORACLEEntityManager",
        transactionManagerRef = "ORACLETransactionManager")
public class ORACLEConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.oracle-datasource")
    public DataSource ORACLEDataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean ORACLEEntityManager() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(ORACLEDataSource());
        em.setPackagesToScan("com.example.Spring_Batch_Test.querydsl.ORACLE");//엔티티 패키지 경로
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaPropertyMap(new HashMap<String, Object>() {{
            put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        }});

        return em;
    }

    @Bean
    public PlatformTransactionManager ORACLETransactionManager() {

        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(ORACLEEntityManager().getObject());

        return tm;
    }
}