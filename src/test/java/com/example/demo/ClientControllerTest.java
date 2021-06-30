package com.example.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.ClientController;
import com.example.demo.dao.ClientRepository;
import com.example.demo.models.Client;
import com.example.demo.models.Gender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import  org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import  org.springframework.test.web.servlet.result.MockMvcResultMatchers;	


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;	



@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = ClientController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private ClientRepository clientRepository;
	
	
	@Test
	@DisplayName("Create New Client")
	void createClient() throws Exception {
		
		Client mockclient = new Client();
		
		mockclient.setId(33L);
		mockclient.setEmail("testing test");		
		mockclient.setGender(Gender.FEMME);
		mockclient.setLastname("testing test");
		
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/client/dto")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(mockclient))
				).andExpect(MockMvcResultMatchers.status().is(200)); //.isCreated()		
		
	}
	
	@Test
	@DisplayName("Get ALL Client")
	void getAllClient() throws  Exception {
		
		Client mockclient = new Client();
		
		mockclient.setId(33L);
		mockclient.setEmail("testing test");		
		mockclient.setGender(Gender.FEMME);
		mockclient.setLastname("testing test");
		
		List<Client> clientList = Collections.singletonList(mockclient);
		
		given(clientRepository.findAll()).willReturn(clientList);
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/client")
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
				.andExpect(content().string("[{\"id\":33,\"firstname\":null,\"lastname\":\"testing test\",\"gender\":\"FEMME\",\"address\":null,\"favoritesSubjects\":null,\"totalMoney\":null,\"createdDate\":null,\"email\":\"testing test\"}]"));
		
			
	}

}
