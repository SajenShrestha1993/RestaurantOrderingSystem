//REST API EndPoints
package com.ibm.newhire.orderms.control;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.newhire.orderms.model.Customer;
import com.ibm.newhire.orderms.model.Order;
import com.ibm.newhire.orderms.service.OrderService;

@RestController
public class OrderController {
//	private static final String OK = null;
	@Autowired
	private OrderService orderService;

	public OrderController(){
		
	}
	
	
	//API to get customer
	@RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveCustomerById(@PathVariable(value="customerId") String customerId){
		Customer customer = orderService.findCustomer(customerId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	
	//API to create an Order
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		order = orderService.addOrder(order);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}

	

	//API to retrieve an order by ID
	@RequestMapping(value = "/order/{orderID}", method = RequestMethod.GET)
	public ResponseEntity<? >retrieveOrderById(@PathVariable(value="orderID") long orderID) {
		Order order = this.orderService.findOrder(orderID);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	
	//API to retrieve all orders
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveAllOrders() {
		List<Order> responseItems = this.orderService.allOrder();
		if(!responseItems.isEmpty()) {
			return new ResponseEntity<>(responseItems,HttpStatus.OK);
		}
		return new ResponseEntity<>("No Orders",HttpStatus.OK);
						
						

	}

}
