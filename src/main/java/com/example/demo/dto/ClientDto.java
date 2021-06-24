package com.example.demo.dto;



import com.example.demo.models.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private String firstname;	
	private String lastname;
	private String email;
	private Gender gender;
	
}
