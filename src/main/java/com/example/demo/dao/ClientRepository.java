package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.dto.ClientDto;
import com.example.demo.models.Client;

public interface ClientRepository extends MongoRepository<Client, Long>{

	Optional<Client> findClientByEmail(String email);
	
//	@Query("select new com.example.demo.dto.ClientDto(U.firstname,U.lastname,U.username,U.email) from Client U")
//	List<ClientDto> getAll();

}
