package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.invocation.Invocation;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.ClientRepository;
import com.example.demo.models.Client;
import com.example.demo.models.Gender;
import com.example.demo.services.ClientService;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest2 {
	
	
	@InjectMocks
    ClientService service;
      
    @Mock
    ClientRepository dao;
     
   
    
    
    @Test
    void shouldSavedUserSuccessfully() {
    	
    	final Long clientId = 39L;

    	Client mockclient = new Client();
  		mockclient.setId(clientId);
  		mockclient.setEmail(" test");		
  		mockclient.setGender(Gender.FEMME);
  		mockclient.setLastname(" test");
  		
  		given(dao.findById(clientId)).willReturn(Optional.empty());
  		given(dao.save(mockclient)).willAnswer(invocation -> invocation.getArgument(0));

  		 Client savedClient = service.save2(mockclient);
  		 
  		assertThat(savedClient).isNotNull();
  		
//  		verify(dao).save((any(Client.class)));
  		
  		
  		
  		
    }
    
    
    
    //findUserById
    @Test
    void findUserById() {
    	
    	final Long clientId = 33L;

    	Client mockclient = new Client();
  		mockclient.setId(clientId);
  		mockclient.setEmail("testing test");		
  		mockclient.setGender(Gender.FEMME);
  		mockclient.setLastname("testing test");
  		
  		given(dao.findById(clientId)).willReturn(Optional.of(mockclient));
  		final Client excepted = service.getById(clientId);
  		
  		assertThat(excepted).isNotNull();
  		
  		
  		
    }
    
    
    
    //update user test
    void updateClient() {
    	final Long clientId = 33L;

    	final Client mockclient = new Client();
  		mockclient.setId(clientId);
  		mockclient.setEmail("testing test");		
  		mockclient.setGender(Gender.FEMME);
  		mockclient.setLastname("testing test");
  		
  		
 		given(dao.save(mockclient)).willReturn(mockclient);
 		
  		final Client excepted = service.updateClient(mockclient);
  		
  		assertThat(excepted).isNotNull();
  		
//  		verify(dao).save(any(Client.class));
  		
  		
  		
  		
    }
    
    
    
    
    
    
    //test findAll
    @Test
    void shouldReturnFindAll() {
    	List<Client> list = new ArrayList<Client>();
        Client mockclient = new Client();
		
		mockclient.setId(63L);
		mockclient.setEmail("testing test");		
		mockclient.setGender(Gender.MALE);
		mockclient.setLastname(" test");
          
        list.add(mockclient);
        
        given(dao.findAll()).willReturn(list);
        
        List<Client> listExcepted = service.getAll();
        
        assertEquals(listExcepted, list);
   
    	
    }
    
    
    
     
    
    @Test
    public void shouldBeDelete() {
    	final Long clientId = 33L;
    	service.deleteById(clientId);
    	service.deleteById(clientId);
    	verify(dao,times(2)).deleteById(clientId);
    }

}
