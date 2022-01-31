package com.mouritech.crudwithhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerid")
	private Long customerId;
	
	@Column(name = "customername")
	@Size(min=3)
	private String customerName;
	
	@Column(name = "customermail")
	@Email
	private String customerEmail;
	
	@Column(name = "customermobileno")
	@Pattern(regexp = "[0-9]", message="mobile number contains only digits")
	private String customerMobileNo;

public Customer() {
	
}

public Long getCustomerId() {
	return customerId;
}

public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCustomerEmail() {
	return customerEmail;
}

public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}

public String getCustomerMobileNo() {
	return customerMobileNo;
}

public void setCustomerMobileNo(String customerMobileNo) {
	this.customerMobileNo = customerMobileNo;
}

public Customer(Long customerId, String customerName, String customerEmail, String customerMobileNo) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerEmail = customerEmail;
	this.customerMobileNo = customerMobileNo;
}

public Customer(String customerName, String customerEmail, String customerMobileNo) {
	super();
	this.customerName = customerName;
	this.customerEmail = customerEmail;
	this.customerMobileNo = customerMobileNo;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail=" + customerEmail
			+ ", customerMobileNo=" + customerMobileNo + "]";
}

}