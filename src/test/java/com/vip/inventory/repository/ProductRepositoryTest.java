package com.vip.inventory.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vip.inventory.config.MongoConfig;
import com.vip.inventory.model.Product;
import com.vip.inventory.model.ProductCatagoryEnum;

@Configuration
@ContextConfiguration(classes= {MongoConfig.class})
public class ProductRepositoryTest extends AbstractTestNGSpringContextTests  {
	


	@Autowired
	ProductRepository repository;
	
	Product product = null;
	
	@BeforeClass
	public void setUp() throws Exception {
		product = new Product("AFCAT",115.0, "AFCAT 2nd Edition", Arrays.asList(ProductCatagoryEnum.BOOKS));
	}

	@AfterClass
	public void tearDown() throws Exception {
	}

	@Test(priority=1)
	public void create() {
		Product prod = repository.insert(product);
		Assert.assertEquals(product, prod);
		
	}
	
	@Test(dependsOnMethods={"create"})
	public void update() {
		Product prodToUpdate = product.clone();
		prodToUpdate.setPrice(200);
		Product prod = repository.save(prodToUpdate);
		Assert.assertEquals(prod.getPrice(), 200.0);
		Assert.assertEquals(prod.getDescription(), product.getDescription());
	}
	
	@Test(dependsOnMethods={"create"})
	public void findbyName() {
		Product prod1 = product.clone();
		prod1.setDescription("AFCAT 1st Edition");
		
		Product prod2 = product.clone();
		prod2.setDescription("AFCAT 3rd Edition");
		
		repository.insert(prod1);
		repository.insert(prod2);
		
		List<Product> prods = repository.findByName("AFCAT");
		Assert.assertEquals(prods.size(), 3);
	}
	
	@Test(dependsOnMethods={"update"})
	public void delete() {
		repository.delete(product.getId());
		Assert.assertEquals(repository.findOne(product.getId()), null);
	}

}
