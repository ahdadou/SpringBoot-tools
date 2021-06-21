package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.ClientDto;
import com.example.demo.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("select new com.example.demo.dto.ClientDto(U.firstname,U.lastname,U.username,U.email) from Client U")
	List<ClientDto> getAll();

}
