package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.Producer;
import com.klef.jfsd.springboot.repositories.AdminRepository;
import com.klef.jfsd.springboot.repositories.ProducerRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	
	@Autowired
	private ProducerRepository producerRepository;

	@Autowired
	private AdminRepository adminRepository;
	
	public String addproducer(Producer pro)
	{ 
		
	  producerRepository.save(pro);
	  return "Registered Successfully";
	}

	@Override
	public List<Producer> viewallproducers()
	{
	    return producerRepository.findAll();
	}

	
	
	public Admin checkAdminLogin(String name, String password) 
	{
		return  adminRepository.checkAdminLogin(name, password);
	}

}
