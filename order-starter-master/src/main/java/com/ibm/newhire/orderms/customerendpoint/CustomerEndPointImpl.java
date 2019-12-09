//Outbound API calls to [Customer Services]
package com.ibm.newhire.orderms.customerendpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ibm.newhire.orderms.model.Customer;
@Component
public class CustomerEndPointImpl implements CustomerEndpoint {

	@Override
	public Customer getCustomerById(String customerEmail) {
		Customer customer;
		String url1 = "http://localhost:9095/customer/" + customerEmail; //api call to Customer Service "findCustomerByID"
		RestTemplate restTemplate = new RestTemplate();
		customer = restTemplate.getForObject(url1,Customer.class); //Retrieved customer object
		return customer;
		
	}

	
}
