package com.klef.jfsd.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.models.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Integer>
{

	@Query("select p from Producer p where email=?1 and password=?2")
	public Producer checkProducerLogin(String email,String password);
	
	
	
}
