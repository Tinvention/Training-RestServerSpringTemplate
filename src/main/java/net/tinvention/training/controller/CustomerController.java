package net.tinvention.training.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tinvention.training.model.Customer;
import net.tinvention.training.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractRestController {

	@Autowired
	private CustomerService customerService;

	@PostConstruct
	protected void init() {
		logger.debug("called");
	}

	@GetMapping
	public List<Customer> list() {
		logger.debug("called");
		return customerService.list();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id) {
		logger.debug("called with id: " + id);
		return customerService.getById(id);
	}

	@PostMapping
	public Long add(@RequestBody Customer toAdd) {
		logger.debug("called with toAdd: " + toAdd);
		return customerService.add(toAdd);
	}

	@PutMapping
	public void update(@RequestBody Customer toUpdate) {
		logger.debug("called with toUpdate: " + toUpdate);
		customerService.updateById(toUpdate);
	}

	@DeleteMapping("/{id}")
	public void update(@PathVariable("id") Long id) {
		logger.debug("called with id: " + id);
		customerService.deleteById(id);
	}

	@GetMapping("/countWithLeak")
	public int countWithLeak() throws SQLException {
		logger.debug("called ");
		return customerService.countWithLeak();
	}

}