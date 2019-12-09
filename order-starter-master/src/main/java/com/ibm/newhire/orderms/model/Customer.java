package com.ibm.newhire.orderms.model;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customer {
//private BigInteger c_id;
private BigInteger id;
@Indexed(unique = true)
private String email;
private String firstName;
private String lastName;
private String city;
private String state;


public String getEmail() {
	return email;
}
public void setEmail(String eMail) {
	this.email = eMail;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public BigInteger getId() {
	return id;
}
public void setId(BigInteger id) {
	this.id = id;
}

}
