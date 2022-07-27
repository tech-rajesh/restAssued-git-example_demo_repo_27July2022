package restAssuredAPI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GET_ListUser {
	
	
	//@Test
	public void GET_TC_01_ListeUser() {
		
		//restassured
		
		baseURI = "https://reqres.in";
		
		
		given().
			header("Content-Type","application/json").
			params("page", "2").
		when().
			get("/api/users?page=2").
			
		then().
			statusCode(201).
			log().all();
		
		
		
		
		
		
	}
	
	
	@Test
	public void GET_TC_02_ListeUser() {
		
		//restassured
		
		baseURI = "https://reqres.in";
		
		
		given().
			header("Content-Type","application/json").
			params("page", "2").
		when().
			get("/api/users").
			
		then().
			statusCode(200).
			log().all();
		
		
		
		
		
		
	}
	

}
