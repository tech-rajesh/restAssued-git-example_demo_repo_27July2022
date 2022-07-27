package restAssuredAPI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Delete_user {
	
	
	@Test
	public void GET_TC_01_ListeUser() {
		
		//restassured
		
		baseURI = "https://reqres.in";
		
		
		given().
			header("Content-Type","application/json").
		when().
			delete("/api/users/1").
		then().
			statusCode(204).
			header("CF-Cache-Status", "DYNAMIC").
			log().all();
		
		
		
		
		
		
	}
	

}
