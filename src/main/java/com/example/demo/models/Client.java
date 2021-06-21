package com.example.demo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String firstname;
	
	@Column(length = 20)
	private String lastname;

	@Column(length = 20, unique = true)
	private String username;
	
	@Column(length = 20, unique = true)
	private String email;
	
	
	private String password;
	
	@ManyToMany(mappedBy = "clients",cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>() ;
	
}
