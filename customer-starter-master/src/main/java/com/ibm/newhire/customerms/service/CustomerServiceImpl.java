package com.ibm.newhire.customerms.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.newhire.customerms.model.Customer;
import com.ibm.newhire.customerms.repo.CustomerRepo;
import com.ibm.newhire.customerms.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

//	@Override
//	public Customer retrieveCustomerByNumber(String id) {
//		Customer customer = this.customerRepo.findById(id);
//		return customer;
//	}

	@Override
	public List<Customer> retrieveCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
        this.customerRepo.save(customer);
		return customer;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer = this.customerRepo.findByEmail(email);
		return customer;
	}
}
