package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Client;
import com.example.demo.models.Gender;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ClientControllerTestJUnit5 {
	
	
	
	@LocalServerPort
    int randomServerPort=8098;
     
    @Test
    public void testAddEmployeeSuccess() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/client/";
        URI uri = new URI(baseUrl);
        
        Client mockclient = new Client();
		
		mockclient.setId(33L);
		mockclient.setEmail("testing test");		
		mockclient.setGender(Gender.FEMME);
		mockclient.setLastname("testing test");
		
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<Client> request = new HttpEntity<>(mockclient, headers);
         
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        Assertions.assertEquals(201, result.getStatusCodeValue());
    }
     
    @Test
    public void testAddEmployeeMissingHeader() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/client/";
        URI uri = new URI(baseUrl);
        
        	Client mockclient = new Client();
		
      		mockclient.setId(33L);
      		mockclient.setEmail("testing test");		
      		mockclient.setGender(Gender.FEMME);
      		mockclient.setLastname("testing test");
         
        HttpHeaders headers = new HttpHeaders();
 
        HttpEntity<Client> request = new HttpEntity<>(mockclient, headers);
         
        try
        {
            restTemplate.postForEntity(uri, request, String.class);
            Assertions.fail();
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assertions.assertEquals(400, ex.getRawStatusCode());
            Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
    }
 
    @Test
    public void testGetEmployeeListSuccessWithHeaders() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
         
        final String baseUrl = "http://localhost:"+randomServerPort+"/client/";
        URI uri = new URI(baseUrl);
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-LOCATION", "USA");
 
        HttpEntity<Client> requestEntity = new HttpEntity<>(null, headers);
 
        try
        {
            restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
            Assertions.fail();
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assertions.assertEquals(400, ex.getRawStatusCode());
            Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
    }
	
	

}
