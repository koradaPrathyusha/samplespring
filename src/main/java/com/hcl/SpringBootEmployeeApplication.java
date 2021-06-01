package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringBootEmployeeApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context1=SpringApplication.run(SpringBootEmployeeApplication.class, args);
	}

}
