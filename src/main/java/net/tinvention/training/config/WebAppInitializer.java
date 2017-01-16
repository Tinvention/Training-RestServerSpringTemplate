package net.tinvention.training.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * 
 * web.xml written in Java 
 * 
 * @author stefano.campanini@tinvention.net.campanini@tinvention.net
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] { AppConfig.class };  // Root Web Context ( Dao, Service, ... )
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebAppConfig.class }; // Servlet Web Context ( Controllers, viewresolvers,... )
  }

  @Override
  protected String[] getServletMappings() {
      return new String[] { "/" };
  }
  
  
}
