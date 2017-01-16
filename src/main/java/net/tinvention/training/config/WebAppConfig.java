package net.tinvention.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import net.tinvention.training.controller.AbstractRestController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={AbstractRestController.class })
public class WebAppConfig extends WebMvcConfigurerAdapter {
 
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
  }

}
