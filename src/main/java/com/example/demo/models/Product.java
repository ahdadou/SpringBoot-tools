package com.example.demo.models;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 20)
	private String name;
	
	@ManyToOne
	private Category category;
	
	@ManyToMany
	@JoinTable(name="client_product",
    joinColumns=@JoinColumn(name="product_id"), 
    inverseJoinColumns=@JoinColumn(name="client_id"))
	private List<Client> clients = new ArrayList<Client>();

}
