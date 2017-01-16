package net.tinvention.training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * it is only for main application
 * 
 * @author stefano.campanini@tinvention.net
 *
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class AppConfig extends CommonConfig {
	
	
}
