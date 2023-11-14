package me.briannewton.etonote;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtonoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtonoteApplication.class, args);
	}

	@Bean
    public ModelMapper getModelMapper() { 
      return new ModelMapper(); 
    } 
}
