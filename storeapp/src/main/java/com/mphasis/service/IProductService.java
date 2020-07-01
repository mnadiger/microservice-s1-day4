package com.mphasis.service;

import java.util.List;

import com.mphasis.domain.Product;

public interface IProductService {

	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	void deleteProductById(Integer id);
	
	Product getProductById(Integer id);
	
	List<Product> getAllProducts();
}
