package com.klef.jfsd.springboot.services;

import com.klef.jfsd.springboot.models.Customer;


public interface CustomerService
{

	
	public String addcustomer(Customer customer);
	public Customer checkCustomerLogin(String email, String pwd);
}
