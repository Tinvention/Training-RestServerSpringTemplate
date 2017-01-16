package net.tinvention.training.config;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractTest {
  
  @Autowired
  protected DataSource dataSource;
  
  
  @Value("classpath:/init-db-test-data.sql")
  protected Resource initDbTestDataScript;


}
