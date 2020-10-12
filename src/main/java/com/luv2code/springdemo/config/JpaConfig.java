package com.luv2code.springdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource( {"classpath:persistence-mysql.properties"} )
@ComponentScan({
    "com.luv2code.springdemo"
})
@EnableJpaRepositories(basePackages = {"com.luv2code.springdemo.repository"})
public class JpaConfig {

	@Autowired
    private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public JpaConfig() {
        super();
    }
	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[] {
            "com.luv2code.springdemo.entity"
        });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(additionalProperties());

        return entityManagerFactoryBean;
    }
	
	final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
        return hibernateProperties;
    }
      
	   @Bean
	    public DataSource dataSource() {
		   ComboPooledDataSource myDataSource = new ComboPooledDataSource();

			// set the jdbc driver
			try {
				myDataSource.setDriverClass("com.mysql.jdbc.Driver");		
			}
			catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}
			
			// for sanity's sake, let's log url and user ... just to make sure we are reading the data
			logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
			logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
			
			// set database connection props
			myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			myDataSource.setUser(env.getProperty("jdbc.user"));
			myDataSource.setPassword(env.getProperty("jdbc.password"));
			
			// set connection pool props
			myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
			myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

			return myDataSource;
	    }
	   
	   private int getIntProperty(String propName) {
			
			String propVal = env.getProperty(propName);
			
			// now convert to int
			int intPropVal = Integer.parseInt(propVal);
			
			return intPropVal;
		}	
	   
	   @Bean
	    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	        final JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }
	   @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }
}
