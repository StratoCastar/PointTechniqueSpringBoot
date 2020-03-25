package com.innov8.pointtechnique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PointTechniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointTechniqueApplication.class, args);
	}

}
