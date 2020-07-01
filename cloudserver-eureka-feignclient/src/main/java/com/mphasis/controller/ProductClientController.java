package com.mphasis.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.mphasis.domain.Product;
import com.mphasis.proxy.ProductServiceProxy;

@RestController
@Scope("request")
public class ProductClientController {

	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		
		Product product = productServiceProxy.getProductById(id);
		return product;
	}
	
	@GetMapping("/get-products")
	public ArrayList<Product> getProduct() {
		
		ArrayList<Product> products = productServiceProxy.getAllProducts();
		return products;
	}

	@PostMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Product addProduct(@RequestBody Product product) {

		return productServiceProxy.addProduct(product);
	}

}
