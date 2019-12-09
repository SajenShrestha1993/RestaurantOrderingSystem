//Outbound API calls to [Menu Services]
package com.ibm.newhire.orderms.menuendpoint;
import org.springframework.web.client.RestTemplate;

import com.ibm.newhire.orderms.model.Item;

public interface MenuEndpoint {
	public Item getMenyByName(RestTemplate restTemplate,String name);
}
