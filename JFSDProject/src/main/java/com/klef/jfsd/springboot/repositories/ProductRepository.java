package com.klef.jfsd.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
	@Query("SELECT p FROM Product p WHERE p.producerid = :producerId")
	List<Product> findAllProductsByProducerId(int producerId);

}
