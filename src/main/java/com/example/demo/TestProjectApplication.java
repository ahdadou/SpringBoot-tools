package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.demo.dao.ClientRepository;
import com.example.demo.models.Address;
import com.example.demo.models.Client;
import com.example.demo.models.Gender;


@SpringBootApplication
public class TestProjectApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}
	
	
//	@Bean
//	CommandLineRunner lineRunner(){
//		return args->{
//			
//		};
//	}

}
