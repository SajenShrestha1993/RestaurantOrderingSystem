package com.ibm.newhire.customerms.service;

import java.math.BigInteger;
import java.util.List;

import com.ibm.newhire.customerms.model.Customer;


public interface CustomerService {
	
//	public Customer retrieveCustomerByNumber(String id);
    public List<Customer> retrieveCustomers();
    public Customer addCustomer(Customer customer);
    public Customer getCustomerByEmail(String email);

}
