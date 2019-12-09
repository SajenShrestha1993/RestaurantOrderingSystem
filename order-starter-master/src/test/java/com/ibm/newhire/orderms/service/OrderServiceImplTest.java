package com.ibm.newhire.orderms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import com.ibm.newhire.orderms.customerendpoint.CustomerEndPointImpl;
import com.ibm.newhire.orderms.model.Customer;
import com.ibm.newhire.orderms.model.Item;
import com.ibm.newhire.orderms.model.Order;
import com.ibm.newhire.orderms.repo.OrderRepository;

class OrderServiceImplTest {

	@Test
	void testAddOrder() {
		//Given
		Customer customer= new Customer();
		Item menu = new Item();
		
		int order_id = 8;
		double totalPrice = 34.89;
		List<String> itemNames = new ArrayList<String>();
		itemNames.add("Pizza"); itemNames.add("Burger");
		String cust_id = "1";
		String customerName = "sajen";
		Order order = new Order(order_id,totalPrice,cust_id,itemNames,customerName);
		String url = "http://localhost:9093/menu/" + itemNames.get(0);
		
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		CustomerEndPointImpl mockedCustomerEndPoint = Mockito.mock(CustomerEndPointImpl.class);
		OrderRepository mockedOrderRepo = Mockito.mock(OrderRepository.class);
		when(mockedCustomerEndPoint.getCustomerById(cust_id)).thenReturn(customer);
		when(restTemplate.getForObject(url, Item.class)).thenReturn(menu);
		when(mockedOrderRepo.save(order)).thenReturn(order);
		
		//When
		Order returnedOrder = mockedOrderRepo.save(order);
		
		//Then
		assertEquals(order,returnedOrder);
		assertEquals(mockedCustomerEndPoint.getCustomerById(cust_id),customer);
		assertEquals(restTemplate.getForObject(url, Item.class),menu);
		
	}

	@Test
	void testFindOrder_OrderFound() {
		//Given
		int id = 5;
		double cost = 7.89;
		List<String> item_names = new ArrayList<String>();
		String customer_id = "5";
		item_names.add("pizza"); item_names.add("burger"); item_names.add("hot-dog");
		Order order = new Order(id,cost,customer_id,item_names,"Boss");
		OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
		when(orderRepository.findById(id)).thenReturn(order);
		
		//When
		Order ReturnedOrder = orderRepository.findById(id);
		
		//Then
		assertEquals(order,ReturnedOrder);
	}

	@Test
	void testFindOrder_OrderNotFound() {
		//Given
		int id = 8;
//		Order order = null;
		OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
		when(orderRepository.findById(id)).thenReturn(null);
		
		//When
		Order returnOrder = orderRepository.findById(id);
		
		//Then
		assertNull(returnOrder);
	}
	@Test
	void testAllOrder() {
		// INITIALIZING
		int id1= 1;
		int id2 = 2;
		String c_id1 = "1";
		String c_id2 = "2";
		double cost = 8.90;
		List<String> item_names = new ArrayList<String>();
		item_names.add("pizza"); 
		item_names.add("burger"); 
		item_names.add("hotdog");
		double cost2 = 9.52;
		List<String> item_names2 = new ArrayList<String>();
		item_names2.add("cheeseburger"); 
		item_names2.add("salad"); 
		item_names2.add("sandwhich");
		Order order1 = new Order(id1,cost, c_id1,item_names, "Jose");
		Order order2 = new Order(id2,cost2, c_id2, item_names2, "Sajen");
		
		List<Order> orderList = new ArrayList<>(Arrays.asList(order1, order2));
		
		OrderService mockedOrderService = Mockito.mock(OrderService.class);
		
		// EXPECTED
		when(mockedOrderService.allOrder()).thenReturn(orderList);
		
		// ACTUAL
		List<Order> returnedOrderList = mockedOrderService.allOrder();
		assertEquals(returnedOrderList, orderList);		
	}

}
