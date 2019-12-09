package com.ibm.newhire.customerms.repo;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.newhire.customerms.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {
	
	public Customer findById(String id);
	public Customer findByEmail(String email);

}

