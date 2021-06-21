package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dto.ClientDto;
import com.example.demo.models.Client;


@Service
@Transactional
public class ClientService {
	
	private ClientRepository clientRepository;
	
	 @Autowired
	 private ModelMapper modelMapper;
	 

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public void save(Client client) {
		clientRepository.save(client);
	}

	public Client getById(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).get();
	}

	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}
	
	public List<ClientDto> getAllDto() {
		// TODO Auto-generated method stub
		return clientRepository.getAll();
	}
	
	
	public List<ClientDto> getAllDto2() {
		// TODO Auto-generated method stub	
		return convertToDto(clientRepository.findAll());
			
	}
	
	
	public List<ClientDto> getAllDto3() {
		// TODO Auto-generated method stub	
		return clientRepository.findAll()
				.stream()
				.map(x -> convertToDto(x))
				.collect(Collectors.toList());
			
	}
	
	
	private ClientDto convertToDto(Client client) {	
		return modelMapper.map(client,ClientDto.class);
	}
	
	private List<ClientDto> convertToDto(List<Client> client) {
	   
		List<ClientDto> c= client.stream()
				.map(x -> modelMapper.map(x,ClientDto.class)).collect(Collectors.toList());
		return c;
		
	}
	
	

}
