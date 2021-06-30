package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDto;
import com.example.demo.exceptions.HandleException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("client")
@Api(value = "ClientController Rest EndPoint",description = "show client API'S")
public class ClientController {
	
	private ClientService clientService;
	


	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@ApiOperation(value = "POST CLIENT USE CLIENT")
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Client client){		
		try {
			clientService.save(client);
			return ResponseEntity.ok("Successfully");
		}catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HandleException(402,"Cant Add this Client",LocalDateTime.now(),"/client"));
		}
	}
	@ApiOperation(value = "POST CLIENT USE DTOCLIENT")
	@PostMapping("/dto")
	public Client saveDto(@RequestBody ClientDto client){	
		System.out.println("*****************************");
		return clientService.saveDto(client);
	}
	
	@ApiOperation(value = "Return Client By Id")
	@ApiResponses(
			value= {
					@ApiResponse(code = 100,message = "100 is the message"),
					@ApiResponse(code = 200,message = "200 is the message"),
					}
			)
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
