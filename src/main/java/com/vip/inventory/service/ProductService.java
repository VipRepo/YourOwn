package com.vip.inventory.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vip.inventory.model.Product;
import com.vip.inventory.repository.ProductRepository;

@Service
public class ProductService {
	
	static Logger log = Logger.getLogger(ProductService.class.getName());
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findOne(BigInteger id) {
		return productRepository.findOne(id);
	}

	public Product create(Product product) {
		return productRepository.insert(product);
	}
	
	public void update(Product product){
		productRepository.save(product);
	}
	
	public List<Product> findByName(String name){
		return productRepository.findByName(name);
	}

}
