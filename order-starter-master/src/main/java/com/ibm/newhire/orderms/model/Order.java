package com.ibm.newhire.orderms.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Order")
public class Order {
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private long id;
	private double totalCost;
	private String customerEmail;
	private List<String> itemNames;
	private String customerNames;
	
	public Order(long id, double totalCost, String customerIds, List<String> itemNames, String customerNames) {
		super();
		this.id = id;
		this.totalCost = totalCost;
		this.customerEmail = customerIds;
		this.itemNames = itemNames;
		this.customerNames = customerNames;
	}

	public Order() {
		super();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerIds) {
		this.customerEmail = customerIds;
	}

	public List<String> getItemNames() {
		return itemNames;
	}

	public void setItemNames(List<String> itemNames) {
		this.itemNames = itemNames;
	}

	public String getCustomerNames() {
		return customerNames;
	}

	public void setCustomerNames(String customerNames) {
		this.customerNames = customerNames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	

	
	
	
}