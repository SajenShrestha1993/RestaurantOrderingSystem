//Outbound API calls to [Menu Services] ***Currently not implemented**
package com.ibm.newhire.orderms.menuendpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ibm.newhire.orderms.model.Item;
@Component
public class MenuEndPointImpl implements MenuEndpoint {

	@Override
	public Item getMenyByName(RestTemplate restTemplate,String name) {
		
		String url = "http//localhost:9093/menu/" + name; //api call to Menu Service "findMenuByID"
		return restTemplate.getForObject(url, Item.class); //Returns Menu Object
		
	}

}
