package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PoolSizeController {

	@Autowired
	private Environment environment;

	@GetMapping("/pool-size")
	public String getPoolSize() {

		return environment.getProperty("spring.datasource.hikari.maximum-pool-size");
	}
}