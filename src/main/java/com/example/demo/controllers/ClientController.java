package com.example.demo.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDto;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

@RestController
@RequestMapping("client")
public class ClientController {
	
	
	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	
	@PostMapping
	public void save(@RequestBody Client client){
		
		clientService.save(client);
	}
	
	@PostMapping("/dto")
	public void saveDto(@RequestBody ClientDto client){
		
		clientService.saveDto(client);
	}
	
	@GetMapping("/{id}")
	public Client getById(@PathVariable("id") Long id) {
		return clientService.getById(id);
	}
	
	@GetMapping
	public List<Client> getAllClient() {
		return clientService.getAll();
	}
	
	
	@GetMapping("/dto")
	public List<ClientDto> getAllClienDTO() {
		return clientService.getAllDto3();
	}
	
	
	

}
