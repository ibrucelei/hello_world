package config;

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
@MapperScan(basePackages = "com.example.demo.mapper.file")//, sqlSessionTemplateRef  = "fileSqlSessionTemplate")
//@EnableJpaRepositories(
		//entityManagerFactoryRef="entityManagerFactoryPrimary", 
		//transactionManagerRef="transactionManagerPrimary", basePackages = {"com.example.demo.mapper.file"} )
public class FileDataSourceConfiguration {
	@Bean(name = "fileDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.file")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "fileSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("fileDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "fileTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("fileDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "fileSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("fileSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
}
