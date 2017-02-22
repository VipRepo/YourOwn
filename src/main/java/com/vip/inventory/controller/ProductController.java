package com.vip.inventory.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vip.inventory.exception.YourOwnException;
import com.vip.inventory.model.Product;
import com.vip.inventory.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Product> listProduct() {
		return productService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Product getProduct(@PathVariable("id") BigInteger id) {
		return productService.findOne(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return productService.create(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> updateProduct(@PathVariable("id") BigInteger id, @RequestBody Product product) throws YourOwnException {
		if(!product.getId().equals(id)){
//			throw new YourOwnException("Invalid Product");
			return new ResponseEntity<String>("Invalid Product", HttpStatus.BAD_GATEWAY);
		}
		if(productService.findOne(id) == null){
//			throw new YourOwnException("Product does not exist");
			return new ResponseEntity<String>("Product does not exist", HttpStatus.NOT_FOUND);
		}
		productService.update(product);
		return new ResponseEntity<String>("Product updated", HttpStatus.OK);
	}
}
