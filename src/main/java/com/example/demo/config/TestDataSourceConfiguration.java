package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.test", sqlSessionFactoryRef="testSqlSessionFactory",sqlSessionTemplateRef  = "testSqlSessionTemplate")
//@EnableJpaRepositories(
		//entityManagerFactoryRef="entityManagerFactoryPrimary", 
		//transactionManagerRef="transactionManagerPrimary", 		basePackages = {"com.example.demo.mapper.test"} )
public class TestDataSourceConfiguration {
	@Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    @Primary
    public DataSource DataSource() {
		//System.out.println("testDataSource");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testSqlSessionFactory")
    @Primary
    public SqlSessionFactory SqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "testTransactionManager")
    @Primary
    public DataSourceTransactionManager TransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "testSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
}
