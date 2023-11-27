package com.klef.jfsd.springboot.services;

import com.klef.jfsd.springboot.models.Producer;

public interface ProducerService
{

	
	public String addproducer(Producer pro);
	public String updateproducer(Producer pro);
	public Producer  checkProducerLogin(String email,String pwd);
	public Producer viewproducerbyid(int pid);
	
	
	
	
	
}
