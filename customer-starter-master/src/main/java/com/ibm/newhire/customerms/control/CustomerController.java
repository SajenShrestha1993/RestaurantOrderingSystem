package com.ibm.newhire.customerms.control;

import java.math.BigInteger;

import com.ibm.newhire.customerms.model.Customer;
import com.ibm.newhire.customerms.service.CustomerService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.ibm.newhire.model.util.MessageKeys;

@RestController
public class CustomerController {

	@Autowired
	protected MessageSource messageSource;

	@Autowired
	private CustomerService customerService;

//	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

//	@RequestMapping(value = "/health", method = RequestMethod.GET)
//	public String health() {
//		return messageSource.getMessage(HEALTH_MESSAGE_ID, null, LocaleContextHolder.getLocale());

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveCustomers() {

		return new ResponseEntity<>(this.customerService.retrieveCustomers(), HttpStatus.OK);

	}

//	@RequestMapping(value="/customer/{customerNumber}", method=RequestMethod.GET)
//	public ResponseEntity<Customer> retrieveCustomerByNumber(@PathVariable String customerNumber) {
//		Customer customer = this.customerService.retrieveCustomerByNumber(customerNumber);
//
//		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//	}

	@RequestMapping(value = "/customer/{customerEmail}", method = RequestMethod.GET)
	public ResponseEntity<Customer> retrieveCustomerByEmail(@PathVariable String customerEmail) {
		Customer customer = this.customerService.getCustomerByEmail(customerEmail);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
		Customer responseCustomer = this.customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(responseCustomer, HttpStatus.OK);
	}

}
