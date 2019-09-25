package net.tinvention.training.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jndi.JndiTemplate;

/**
 * it is only for main application
 * 
 * @author stefano.campanini@tinvention.net
 *
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class AppConfig extends CommonConfig {

	/**
	 * 
	 * 
	 * @return
	 * @throws NamingException
	 */
	@Bean
	public DataSource getDataSource() throws NamingException {
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		dataSource = jndi.lookup(env.getProperty("main.ds.jndi"), DataSource.class);

		return dataSource;
	}

}
