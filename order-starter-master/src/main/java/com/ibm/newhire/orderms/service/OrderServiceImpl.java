//Service Layer
package com.ibm.newhire.orderms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.newhire.orderms.customerendpoint.CustomerEndpoint;

import com.ibm.newhire.orderms.model.Customer;
import com.ibm.newhire.orderms.model.Item;
import com.ibm.newhire.orderms.model.Order;
import com.ibm.newhire.orderms.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	//[Dependency Injection]
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private CustomerEndpoint customerEndPoint;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	//[CreateOrder]
	@Override
	public Order addOrder(Order order) {
		
				Item menu = null;
				Customer customer = null;
				double totalPrice = 0.0;
				List<String> itemNames = order.getItemNames(); //List of order Items passed to [Order] Response Body
				String customerId = order.getCustomerEmail(); //Customer Id passed to the response body
				try 
				{

					customer = customerEndPoint.getCustomerById(customerId); //API call to [customer service]
					String customerName = customer.getFirstName(); 
					System.out.println("Name: "+customerName);
					order.setCustomerNames(customerName); //Associating customer to the current order
				}
				catch(Exception e)
				{
					e.getStackTrace();
				}
				RestTemplate restTemplate = new RestTemplate(); //RestTemplate for making API call to [menu service]
				try 
				{
					//Run loop through list of items passed to the Response body
					for(String item:itemNames ) 
					{ 
						String url = "http://localhost:9093/menu/" + item; //API call to [menu service]
						menu = restTemplate.getForObject(url, Item.class);
						totalPrice = totalPrice + menu.getPrice(); //total price calculation
					}
					 
					 order.setTotalCost(totalPrice); //Setting total cost of the order
				}
				
				catch (Exception e)
				{
					System.out.println("Error");
					System.out.println(e.getStackTrace());
				}
				order.setId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
				order = orderRepo.save(order);
				return order;
	}
	
	//[findOrderById]
	@Override
	public Order findOrder(long id) {
		Order order = this.orderRepo.findById(id);
		return order;
	}

	//[findAllOrder]
	@Override
	public List<Order> allOrder() {
		List<Order> orderItems = null;
		orderItems = (List<Order>) this.orderRepo.findAll();
		return orderItems;
	}
	
	//Outbound API call [findCustomerById] : Just for Testing
	@Override
	public Customer findCustomer(String customerId) {
		Customer customer = null;
		try {
			customer = customerEndPoint.getCustomerById(customerId);
			return customer;
		}
		catch(Exception e){
			e.getStackTrace();
		}
		return customer;
		
	}
	
	

}
