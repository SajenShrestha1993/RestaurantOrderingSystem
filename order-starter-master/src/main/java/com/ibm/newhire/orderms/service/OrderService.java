//Service Layer
package com.ibm.newhire.orderms.service;

import java.util.List;

import com.ibm.newhire.orderms.model.Customer;
import com.ibm.newhire.orderms.model.Order;


public interface OrderService {
	public Order addOrder(Order order);
	public Order findOrder(long orderID);
	public List<Order> allOrder();
	
	public Customer findCustomer(String customerId);
}
