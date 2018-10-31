/*package cn.net.mine;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

*//**
 * csms_v5数据库连接配置
 * 
 *//*
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryCsms", transactionManagerRef = "transactionManager",
basePackages = {"cn.net.minu"})
@EnableTransactionManagement
public class CsmsDataSourceConfigBak {
	*//**
	 * Init Date Source
	 * 
	 * @param environment
	 * @return dataSource
	 * @throws PropertyVetoException 
	 *//*
	@Primary
	@Bean(name = "dataSourceCsms")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms")
	public DataSource dataSource(Environment environment) throws PropertyVetoException {
		System.out.println("Environment(spring.dataSourceCsms):"
				+ environment.getProperty("spring.dataSourceCsms.name"));
		ComboPooledDataSource ds = new ComboPooledDataSource();
        // 设置JDBC的Driver类
        ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.driverClassName"));  // 参数由 Config 类根据配置文件读取
        // 设置JDBC的URL
        ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.url"));
        // 设置数据库的登录用户名
        ds.setUser(environment.getProperty("spring.dataSourceCsms.username"));
        // 设置数据库的登录用户密码
        ds.setPassword(environment.getProperty("spring.dataSourceCsms.password"));
        // 设置连接池的最大连接数
        ds.setMaxPoolSize(1000);
        // 设置连接池的最小连接数
        ds.setMinPoolSize(20);
        //当连接池中的连接耗尽的时候c3p0一次同时获取的连接数
        ds.setAcquireIncrement(10);
        //最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
        ds.setMaxIdleTime(0);
        //初始化连接池的大小
        ds.setInitialPoolSize(10);
        // 每60秒检查所有连接池中的空闲连接。Default: 0
        ds.setIdleConnectionTestPeriod(120);
        //定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
        ds.setAcquireRetryAttempts(60);
        ds.setBreakAfterAcquireFailure(true);
        ds.setTestConnectionOnCheckout(false);
        return ds;
		//return DataSourceBuilder.create().build();
	}
	
	
	//lj 102
	*//**
	 * Init Date Source
	 * 
	 * @param environment
	 * @return dataSource
	 * @throws PropertyVetoException 
	 *//*
	@Bean(name = "ljDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.lj")
	public DataSource dataSourceTwo(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.lj.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.lj.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.lj.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.lj.password"));
	    // 设置连接池的最大连接数
	    ds.setMaxPoolSize(25);
	    // 设置连接池的最小连接数
	    ds.setMinPoolSize(20);
	    //当连接池中的连接耗尽的时候c3p0一次同时获取的连接数
	    ds.setAcquireIncrement(10);
	    //最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
	    ds.setMaxIdleTime(0);
	    //初始化连接池的大小
	    ds.setInitialPoolSize(10);
	    // 每60秒检查所有连接池中的空闲连接。Default: 0
	    ds.setIdleConnectionTestPeriod(120);
	    //定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
	    ds.setAcquireRetryAttempts(60);
	    ds.setBreakAfterAcquireFailure(true);
	    ds.setTestConnectionOnCheckout(false);
	    ds.setCheckoutTimeout(10);
	    return ds;
		//return DataSourceBuilder.create().build();
	}

	*//**
	 * Initialize the JPA supplier adapter
	 * 
	 * @return adapter
	 *//*
	@Bean(name = "jpaVendorAdapterCsms")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		// show sql
		adapter.setShowSql(true);
		// generation DDL
		adapter.setGenerateDdl(false);
		// sql language
		adapter.setDatabase(Database.ORACLE);
		return adapter;
	}

	*//**
	 * Init Date Entity Manager Factory
	 * 
	 * @param dataSource
	 * @param jpaVendorAdapter
	 * @return entityManagerFactory
	 *//*
	@Bean(name = "entityManagerFactoryCsms")
	public EntityManagerFactory entityManagerFactory(
			@Qualifier("dataSourceCsms") DataSource dataSource,
			@Qualifier("jpaVendorAdapterCsms") JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan("cn.net.minu");
		lef.setPersistenceUnitName("persistenceUnitCsms");
		lef.afterPropertiesSet();
		return lef.getObject();

	}

	*//**
	 * Init Date Entity Manager
	 * 
	 * @param entityManagerFactory
	 * @return entityManager
	 *//*
	@Bean(name = "entityManagerCsms")
	public EntityManager entityManager(
			@Qualifier("entityManagerFactoryCsms") EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}

	*//**
	 * Init Transaction Manager
	 * 
	 * @param entityManagerFactory
	 * @return platformTransactionManager
	 *//*
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactoryCsms") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	*//**
	 * Init Spring JdbcTemplate
	 * 
	 * @param datasource
	 * @return jdbcTemplate
	 *//*
	@Bean(name = "jdbcTemplateCsms")
	public JdbcTemplate jdbcTemplate(
			@Qualifier("dataSourceCsms") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	*//**
	 * lj
	 * @param datasource
	 *//*
	@Bean(name = "ljJdbcTemplate")
	public JdbcTemplate ljJdbcTemplate(
			@Qualifier("ljDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
*/