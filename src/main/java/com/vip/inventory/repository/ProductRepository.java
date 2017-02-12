package com.vip.inventory.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vip.inventory.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, BigInteger> {

	 public List<Product> findByName(String name);
	    
  // additional custom finder methods go here
}