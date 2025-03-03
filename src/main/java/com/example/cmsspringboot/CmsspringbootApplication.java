package com.example.cmsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.cmsspringboot.mapper") // Tambahkan jika pakai MyBatis
@ComponentScan("com.example.cmsspringboot")
public class CmsspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsspringbootApplication.class, args);
	}

}
