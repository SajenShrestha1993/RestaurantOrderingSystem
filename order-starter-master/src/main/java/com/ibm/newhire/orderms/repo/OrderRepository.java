package com.ibm.newhire.orderms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.newhire.orderms.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
	public Order findById(long id);
}
