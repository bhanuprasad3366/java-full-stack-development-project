package com.klef.jfsd.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Customer;
import com.klef.jfsd.springboot.models.Producer;
import com.klef.jfsd.springboot.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	
	public String addcustomer(Customer customer) 
	{
		customerRepository.save(customer);
		return "Customer Registered Sucessfully";
	}
	
	
	public Customer checkCustomerLogin(String email, String pwd) 
	{
	  return  customerRepository.checkCustomerLogin(email, pwd);
	
	}

}
