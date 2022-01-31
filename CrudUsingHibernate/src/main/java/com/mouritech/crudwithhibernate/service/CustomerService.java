package com.mouritech.crudwithhibernate.service;
import java.util.Scanner;

import com.mouritech.crudwithhibernate.dao.CustomerDao;
import com.mouritech.crudwithhibernate.entity.Customer;
public class CustomerService {
	static Scanner sc = new Scanner(System.in);
	CustomerDao customerdao = new CustomerDao();

	
	public void customerSave() {
		Customer customer = new Customer();
		System.out.println("Enter the details of the customer");
		//sc.nextLine()
		System.out.println("Enter the customer name....");
		customer.setCustomerName(sc.nextLine());
		System.out.println("Enter the customer email....");
		customer.setCustomerEmail(sc.nextLine());
		System.out.println("Enter the customer mobile number....");
		customer.setCustomerMobileNo(sc.nextLine());
		customerdao.customerSave(customer);	
	}

	public void getAllCustomer() {
		
		customerdao.getAllCustomer();
	}
	
	public void deleteCustomer() {

		System.out.println("Enter the customer id to delete....");
		Long customerid = sc.nextLong();
        customerdao.deleteCustomer(Customer.class,new Long(customerid));
	}

	public void updateCustomer() {
		Customer customer = new Customer();
		System.out.println("Enter the details of the customer");
		//sc.nextLine()
		System.out.println("Enter the customer name....");
		customer.setCustomerName(sc.nextLine());
		System.out.println("Enter the customer email....");
		customer.setCustomerEmail(sc.nextLine());
		System.out.println("Enter the customer mobile number....");
		customer.setCustomerMobileNo(sc.nextLine());
		//empdao.employeeSave(emp);	
		//empdao.updateEmployee(emp);
	}
	
	public  void getDetailsToUpdate() {
		System.out.println("Enter the employee id....");
		Long customerid = sc.nextLong();
		System.out.println("Enter the mobile no");
		String customermobileno = sc.next();
		//return mobNo;
		customerdao.updateCustomer(customerid,customermobileno);
	}

	public void getCustomerById() {
		System.out.println("Enter the customer id....");
		Long customerid = sc.nextLong();
		customerdao.getCustomerById(customerid);
	}
	public void getCustomerByName() {
		System.out.println("Enter the customer name....");
		String customerName = sc.nextLine();
		customerdao.getCustomerByName(customerName);
	}


}