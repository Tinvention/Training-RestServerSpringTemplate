package net.tinvention.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


public abstract class AbstractRestController {
  
  protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
