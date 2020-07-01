package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudserverConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudserverConfigApplication.class, args);
	}

}
