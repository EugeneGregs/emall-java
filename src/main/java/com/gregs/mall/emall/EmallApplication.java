package com.gregs.mall.emall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmallApplication.class, args);
	}

}
