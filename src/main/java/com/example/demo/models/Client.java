package com.example.demo.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "client")
public class Client {
	
	@Id
	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	@Indexed(unique = true)
	private String Email;

	private Gender gender;
	
	private Address address;
	
	private List<String> favoritesSubjects;
	
	private BigDecimal totalMoney;
	
	private LocalDateTime createdDate;
	

	
	
}
