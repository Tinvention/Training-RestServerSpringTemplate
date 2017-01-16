package net.tinvention.training.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tinvention.training.dao.CustomerDao;
import net.tinvention.training.model.Customer;

@Service
public class CustomerService extends AbstractService {
  
  @Autowired
  private CustomerDao customerDao;
  
  @PostConstruct
  protected void init() {
    logger.debug("called");
  }

  public Customer getById(final Long id) {
    return customerDao.getById(id);
  }

  public List<Customer> list() {
    return customerDao.list();
  }

  public Long add(Customer Customer) {
    return customerDao.add(Customer);
  }

  public void updateById(Customer Customer) {
    customerDao.updateById(Customer);
  }

  public void deleteById(Long pid) {
    customerDao.deleteById(pid);
  }
  
}
