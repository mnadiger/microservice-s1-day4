package com.mphasis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.domain.Product;
import com.mphasis.repository.ProductRepository;

@Service(value = "productService")
@Scope(value = "singleton")
@Transactional
public class ProductService implements IProductService {

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {

		productRepository.deleteById(id);
	}

	@Override
	public Product getProductById(Integer id) {

		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

}
