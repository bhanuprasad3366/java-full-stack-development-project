package com.klef.jfsd.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Producer;
import com.klef.jfsd.springboot.repositories.ProducerRepository;

@Service
public class ProducerServiceImpl implements ProducerService
{

	@Autowired
	private ProducerRepository producerRepository;
	
	
	public String addproducer(Producer pro) 
	{
	  producerRepository.save(pro);
	  return "Registered Successfully";
	}

	
	public String updateproducer(Producer pro)
	{
		
	   Producer p=producerRepository.findById(pro.getId()).get();
	    
	    p.setName(pro.getName());
	    p.setEmail(pro.getEmail());
	    p.setPassword(pro.getPassword());
	    p.setGender(pro.getGender());
	    p.setAddress(pro.getAddress());
	    p.setContactno(pro.getContactno());
	    
	    producerRepository.save(p);
	    
	    return "Producer Updated Successfully";
	}


	
	public Producer checkProducerLogin(String email, String pwd) 
	{
	  return  producerRepository.checkProducerLogin(email, pwd);
	
	}


	@Override
	public Producer viewproducerbyid(int pid) 
	{
       
     Optional<Producer> obj = producerRepository.findById(pid);  

	    
	    if(obj.isPresent())
	    {
	      Producer pro = obj.get();
	      return pro;
	    }
	    else
	    {
	      return null;
	    }
	}
	
	
	}
	


