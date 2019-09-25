package net.tinvention.training.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.tinvention.training.dao.AbstractDao;
import net.tinvention.training.service.AbstractService;

/**
 * it is common to unit tests and the main application
 * 
 * @author stefano.campanini@tinvention.net
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = { AbstractDao.class, AbstractService.class })
public abstract class CommonConfig {

	@Autowired
	protected Environment env;

	@Value("classpath:/init-db.sql")
	private Resource initDbScript;

	@Bean
	public PlatformTransactionManager getTransactionManager(final DataSource dataSource) {
		PlatformTransactionManager txManager = new DataSourceTransactionManager(dataSource);
		return txManager;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	private DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setIgnoreFailedDrops(false);

		populator.addScript(initDbScript);
		return populator;
	}

}
