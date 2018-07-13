package net.tinvention.training.service;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.tinvention.training.config.AbstractTest;

public class CustomerServiceTest extends AbstractTest  {
  
  @Autowired
  private CustomerService customerService;

  @Test
  public void testGetById() {
    fail("Not yet implemented");
  }

  @Test
  public void testList() {
    assertTrue(customerService.list().size() > 0 );
  }

  @Test
  public void testAdd() {
    fail("Not yet implemented");
  }

  @Test
  public void testUpdateById() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteById() {
    fail("Not yet implemented");
  }

}
