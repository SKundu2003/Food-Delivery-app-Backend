package com.PlaceOrderMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope  //express an endpoint named "/refresh" to import the changes in properties with out restarting
@EnableFeignClients
public class PlaceOrderMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceOrderMicroserviceApplication.class, args);
	}

}
