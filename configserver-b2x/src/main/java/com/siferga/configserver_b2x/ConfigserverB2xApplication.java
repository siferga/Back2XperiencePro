package com.siferga.configserver_b2x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigserverB2xApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverB2xApplication.class, args);
	}

}
