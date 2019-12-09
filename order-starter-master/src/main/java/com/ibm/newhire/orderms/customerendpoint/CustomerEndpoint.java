//Outbound API calls to [Customer Services]
package com.ibm.newhire.orderms.customerendpoint;
import com.ibm.newhire.orderms.model.Customer;

public interface CustomerEndpoint {
 public Customer getCustomerById(String customerEmail);
}
