package com.vocSys.voc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.vocSys.voc.mapper")
@SpringBootApplication
@ServletComponentScan
public class VocApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocApplication.class, args);
	}

}
