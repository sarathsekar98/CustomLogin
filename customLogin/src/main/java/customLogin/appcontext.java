package customLogin;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@PropertySource(value="classpath:app.properties")
public class appcontext {
	
	@Autowired
	Environment env;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver()
	{
	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}
	
	@Bean
	public DataSource dataSource()
	{
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		try {
			securityDataSource.setDriverClass("com.mysql.jdbc.Driver");		
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(
		getIntProperty("connection.pool.initialPoolSize"));

		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
		
	}
	

	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean()
	{
		LocalSessionFactoryBean lb = new LocalSessionFactoryBean();
		lb.setDataSource(dataSource());
		lb.setPackagesToScan(new String[] {"customLogin.module"});
		lb.setHibernateProperties(hiberProperties());
		return lb;
	}
	
	@Bean
	public Properties hiberProperties()
	{
		Properties p= new Properties();
		p.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
		p.setProperty("hibernate.show_sql","true");
		p.setProperty("hibernate.formate_sql", "true");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		return p;
	}
	
	@Bean
	public HibernateTransactionManager txManager()
	{
		HibernateTransactionManager hT= new HibernateTransactionManager();
		hT.setSessionFactory(sessionFactoryBean().getObject());
		return hT;
	}
	
	@Bean
	public PasswordEncoder encoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	

}
