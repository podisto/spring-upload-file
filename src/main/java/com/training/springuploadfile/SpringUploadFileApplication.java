package com.training.springuploadfile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringUploadFileApplication {

	public static void main(String[] args) {
		log.info("--- start application ---");
		SpringApplication.run(SpringUploadFileApplication.class, args);
	}

}
