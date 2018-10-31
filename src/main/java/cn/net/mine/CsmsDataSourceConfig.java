package cn.net.mine;

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

/**
 * csms_v5数据库连接配置
 * 
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryCsms", transactionManagerRef = "transactionManager",
basePackages = {"cn.net.minu"})
@EnableTransactionManagement
public class CsmsDataSourceConfig {

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
	//ju_hongmo
	@Bean(name = "juhmDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.ju")
	public DataSource juhmDataSource(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.ju.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.ju.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.ju.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.ju.password"));
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
	}
	//lj 106
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
	}
	//hongmo   xjk
	@Bean(name = "xjhmDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.xjk")
	public DataSource xjhmDataSource(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.xjk.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.xjk.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.xjk.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.xjk.password"));
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
	}
	
	//hongmo   xxk
	@Bean(name = "xxhmDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.xxk")
	public DataSource xxhmDataSource(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.xxk.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.xxk.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.xxk.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.xxk.password"));
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
	}
	//hongmo   xlk
	@Bean(name = "xlhmDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.xlk")
	public DataSource xlhmDataSource(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.xlk.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.xlk.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.xlk.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.xlk.password"));
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
	}
	//hongmo   xqk
	@Bean(name = "xqhmDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.xqk")
	public DataSource xqhmDataSource(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.xqk.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.xqk.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.xqk.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.xqk.password"));
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
	}
	//hongmo   xtk
	@Bean(name = "xthmDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.xtk")
	public DataSource xthmDataSource(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.xtk.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.xtk.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.xtk.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.xtk.password"));
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
	}
	//hongmo   lhk
	@Bean(name = "lhhmDataSource")
	@ConfigurationProperties(prefix = "spring.dataSourceCsms.lhk")
	public DataSource lhhmDataSource(Environment environment) throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
	    // 设置JDBC的Driver类
	    ds.setDriverClass(environment.getProperty("spring.dataSourceCsms.lhk.driverClassName"));  // 参数由 Config 类根据配置文件读取
	    // 设置JDBC的URL
	    ds.setJdbcUrl(environment.getProperty("spring.dataSourceCsms.lhk.url"));
	    // 设置数据库的登录用户名
	    ds.setUser(environment.getProperty("spring.dataSourceCsms.lhk.username"));
	    // 设置数据库的登录用户密码
	    ds.setPassword(environment.getProperty("spring.dataSourceCsms.lhk.password"));
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
	}
	/**
	 * Initialize the JPA supplier adapter
	 * 
	 * @return adapter
	 */
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

	/**
	 * Init Date Entity Manager Factory
	 * 
	 * @param dataSource
	 * @param jpaVendorAdapter
	 * @return entityManagerFactory
	 */
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

	/**
	 * Init Date Entity Manager
	 * 
	 * @param entityManagerFactory
	 * @return entityManager
	 */
	@Bean(name = "entityManagerCsms")
	public EntityManager entityManager(
			@Qualifier("entityManagerFactoryCsms") EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}

	/**
	 * Init Transaction Manager
	 * 
	 * @param entityManagerFactory
	 * @return platformTransactionManager
	 */
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactoryCsms") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	/**
	 * Init Spring JdbcTemplate
	 * 
	 * @param datasource
	 * @return jdbcTemplate
	 */
	@Bean(name = "jdbcTemplateCsms")
	public JdbcTemplate jdbcTemplate(
			@Qualifier("dataSourceCsms") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	//ju_hongmo
    @Qualifier("juHmJdbcTemplate")
    @Bean(name = "juHmJdbcTemplate")  
    public JdbcTemplate juHmJdbcTemplate(@Qualifier("juhmDataSource")DataSource dataSource){  
        return new JdbcTemplate(dataSource);  
    }  
    //ju  lj
	@Bean(name = "ljJdbcTemplate")
	public JdbcTemplate ljJdbcTemplate(
			@Qualifier("ljDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	//****************************jdbcTemplate hm************************************************
    //hongmo   xjk
    @Qualifier("xjkHmJdbcTemplate")
    @Bean(name = "xjkHmJdbcTemplate")  
    public JdbcTemplate xjhmJdbcTemplate(@Qualifier("xjhmDataSource")DataSource dataSource){  
        return new JdbcTemplate(dataSource);  
    }  
    //hongmo   xxk
    @Qualifier("xxkHmJdbcTemplate")
    @Bean(name = "xxkHmJdbcTemplate")  
    public JdbcTemplate xxhmJdbcTemplate(@Qualifier("xxhmDataSource")DataSource dataSource){  
        return new JdbcTemplate(dataSource);  
    } 
    //hongmo   xlk
    @Qualifier("xlkHmJdbcTemplate")
    @Bean(name = "xlkHmJdbcTemplate")  
    public JdbcTemplate xlhmJdbcTemplate(@Qualifier("xlhmDataSource")DataSource dataSource){  
        return new JdbcTemplate(dataSource);  
    } 
    //hongmo   xqk
    @Qualifier("xqkHmJdbcTemplate")
    @Bean(name = "xqkHmJdbcTemplate")  
    public JdbcTemplate xqhmJdbcTemplate(@Qualifier("xqhmDataSource")DataSource dataSource){  
        return new JdbcTemplate(dataSource);  
    } 
    //hongmo   xtk
    @Qualifier("xtkHmJdbcTemplate")
    @Bean(name = "xtkHmJdbcTemplate")  
    public JdbcTemplate xthmJdbcTemplate(@Qualifier("xthmDataSource")DataSource dataSource){  
        return new JdbcTemplate(dataSource);
    } 
    //hongmo   lhk
    @Qualifier("lhkHmJdbcTemplate")
    @Bean(name = "lhkHmJdbcTemplate")
    public JdbcTemplate lhhmJdbcTemplate(@Qualifier("lhhmDataSource")DataSource dataSource){  
        return new JdbcTemplate(dataSource);  
    } 

}
