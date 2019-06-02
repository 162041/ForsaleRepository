package com.s162041.Forsale;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.s162041.Forsale.dao")
public class ForsaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForsaleApplication.class, args);
	}

}
