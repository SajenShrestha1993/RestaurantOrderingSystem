//package com.ibm.newhire.customerms.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.mockito.Mockito.when;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Arrays;
//
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import com.ibm.newhire.customerms.model.Customer;
//
//public class CustomerServiceImplTest {
//
//	@Test
//	public void testRetrieveCustomerByNumber_found() {
//
//		// INITIALIZING
//		CustomerService mockedCustomerService = Mockito.mock(CustomerService.class);
//		Customer customer = new Customer("Shiv", "FromPrison", "Prison", "CA");
//		String customerId = customer.getId();
//
//		// EXPECTED
//		when(mockedCustomerService.retrieveCustomerByNumber(customerId)).thenReturn(customer);
//
//		// ACTUAL
//		Customer returnedCustomer = mockedCustomerService.retrieveCustomerByNumber(customerId);
//		assertEquals(returnedCustomer, customer);
//	}
//	
//	@Test
//	public void testRetrieveCustomerByNumber_notFound() {
//		
//		// INITIALIZING
//		CustomerService mockedCustomerService = Mockito.mock(CustomerService.class);
//		Customer customer = new Customer("Shiv", "FromPrison", "Prison", "CA");
//		String customerId = customer.getId();
//		
//		// EXPECTED
//		when(mockedCustomerService.retrieveCustomerByNumber(customerId)).thenReturn(null);
//		
//		// ACTUAL
//		Customer returnedCustomer = mockedCustomerService.retrieveCustomerByNumber(customerId);
//		assertNull(returnedCustomer);
//
//	}
//
//	@Test
//	public void testRetrieveCustomers_found() {
//
//		// INITIALIZING
//		Customer customer0 = new Customer("Braeioudon", "Krispy", "Denton", "TX");
//		Customer customer1 = new Customer("Shiv", "FromPrison", "Prison", "CA");
//		List<Customer> customerList = new ArrayList<>(Arrays.asList(customer0, customer1));
//		
//		CustomerService mockedCustomerService = Mockito.mock(CustomerService.class);
//
//		// EXPECTED
//		when(mockedCustomerService.retrieveCustomers()).thenReturn(customerList);
//
//		// ACTUAL
//		List<Customer> returnedCustomerList = mockedCustomerService.retrieveCustomers();
//		assertEquals(returnedCustomerList, customerList);
//	}
//	
//	@Test
//	public void testRetrieveCustomers_notFound() {
//		
//		// INITIALIZING
//		CustomerService mockedCustomerService = Mockito.mock(CustomerService.class); 
//		
//		// EXPECTED
//		when(mockedCustomerService.retrieveCustomers()).thenReturn(null);
//		
//		// ACTUAL
//		List<Customer> returnedCustomerList = mockedCustomerService.retrieveCustomers();
//		assertNull(returnedCustomerList);
//	}
//
//	@Test
//    public void testAddCustomer() {
//
//		// INITIALIZING
//		Customer customer = new Customer("Jose", "Moustache-Man", "New Moustache City", "TX");
//		
//		CustomerService mockedCustomerService = Mockito.mock(CustomerService.class);
//		
//		// EXPECTED
//		when(mockedCustomerService.addCustomer(customer)).thenReturn(customer);
//		
//		// ACTUAL
//		Customer returnedCustomer = mockedCustomerService.addCustomer(customer);
//		assertEquals(returnedCustomer, customer);
//	}
//}
