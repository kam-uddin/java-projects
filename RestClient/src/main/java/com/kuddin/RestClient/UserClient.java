package com.kuddin.RestClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class UserClient 
{
	private static final String USERS_API_URL = "https://reqres.in/api/users?page=";
	
    public static void main( String[] args )
    {
	    try {
		 UserClient.queryUsers(1).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    static List<User> queryUsers(int pageNumber) throws IOException, InterruptedException{
    	HttpClient client = HttpClient.newHttpClient();
    	HttpRequest request = HttpRequest.newBuilder()
    			.GET()
    			.headers("accept", "application/json")
    			.uri(URI.create(USERS_API_URL + pageNumber))
    			.build();
    	HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    	
    	ObjectMapper mapper = new ObjectMapper();
    	JsonNode jsonNode = mapper.readTree(response.body());
        JsonNode data = jsonNode.get("data");

        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	List<User> users = mapper.readValue(data.toString(), new TypeReference<List<User>>() {});
    
    	return users;
    }
}
