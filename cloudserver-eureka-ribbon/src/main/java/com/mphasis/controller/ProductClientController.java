package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Product;

import java.util.Arrays;
import java.util.List;

@RestController
@Scope("request")
public class ProductClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		
		Product product = restTemplate.getForObject("http://product-service/products/"+id, Product.class);
		return product;
	}


	@PostMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code =  HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		return restTemplate.postForObject("http://product-service/products/", product, Product.class);
	}

}





