package com.vip.inventory.service;

import org.testng.annotations.Test;

import com.vip.inventory.model.Product;
import com.vip.inventory.model.ProductCatagoryEnum;

import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;

@ContextConfiguration(classes = ProductService.class)
public class ProductServiceTest extends AbstractTestNGSpringContextTests  {
	
	@Autowired
	ProductService productService;

	
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }


  @Test
  public void findAll() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void findByName() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void findOne() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void save() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void update() {
	  Product product = new Product("Test", 100, "Test Product", Arrays.asList(ProductCatagoryEnum.TEST));
	  
	  product = productService.create(product);
	  
	  
  }
}
