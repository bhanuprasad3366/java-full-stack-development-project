package com.klef.jfsd.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.models.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

	@Query("select c from Customer c where email=?1 and password=?2")
	public Customer checkCustomerLogin(String email,String password);
	
}