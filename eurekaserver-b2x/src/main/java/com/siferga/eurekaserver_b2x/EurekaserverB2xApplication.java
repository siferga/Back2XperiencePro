package com.siferga.eurekaserver_b2x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverB2xApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverB2xApplication.class, args);
	}

}
