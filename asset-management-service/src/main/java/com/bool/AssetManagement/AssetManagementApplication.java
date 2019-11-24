package com.bool.AssetManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class AssetManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(AssetManagementApplication.class, args);
	}

}
