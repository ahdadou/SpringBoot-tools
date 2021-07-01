package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.ClientRepository;
import com.example.demo.models.Client;
import com.example.demo.models.Gender;
import com.example.demo.services.ClientService;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
	
	
	@InjectMocks
    ClientService service;
      
    @Mock
    ClientRepository dao;
     
    @Test
    public void testFindAllEmployees()
    {
        List<Client> list = new ArrayList<Client>();
        Client mockclient = new Client();
		
		mockclient.setId(33L);
		mockclient.setEmail("testing test");		
		mockclient.setGender(Gender.FEMME);
		mockclient.setLastname("testing test");
          
        list.add(mockclient);
   
          
        when(dao.findAll()).thenReturn(list);
          
        //test
        List<Client> empList = service.getAll();
          
        assertEquals(1, empList.size());
        verify(dao, times(1)).findAll();
    }
     
    @Test
    public void testCreateOrSaveEmployee()
    {
    	Client mockclient = new Client();
		
		mockclient.setId(33L);
		mockclient.setEmail("testing test");		
		mockclient.setGender(Gender.FEMME);
		mockclient.setLastname("testing test");
          
        service.save(mockclient);
          
        verify(dao, times(1)).save(mockclient);
    }

}
