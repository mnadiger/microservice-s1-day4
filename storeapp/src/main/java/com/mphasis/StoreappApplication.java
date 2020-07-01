package com.mphasis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.mphasis.domain.Product;
import com.mphasis.repository.ProductRepository;

@EnableEurekaClient
@SpringBootApplication
public class StoreappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StoreappApplication.class, args);
	}

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new Product("LG", 43534.0));
		productRepository.save(new Product("Samsung", 33534.0));
		productRepository.save(new Product("Apple", 53534.0));
		productRepository.save(new Product("Dell", 23534.0));
		productRepository.save(new Product("hp", 13534.0));
		
		System.out.println(productRepository.findAll());
	}
}
