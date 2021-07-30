package com.springboot.demo.test_app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@MapperScan("com.springboot.demo.test_app.dao")
@EnableOpenApi
@SpringBootApplication(scanBasePackages = "com.springboot.demo.test_app")
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class,args);
	}

}
