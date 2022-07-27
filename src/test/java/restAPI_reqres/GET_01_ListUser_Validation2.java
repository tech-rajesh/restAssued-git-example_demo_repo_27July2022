package restAPI_reqres;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET_01_ListUser_Validation2 {

	Response response;
	
	@Test
	public void verifyStatusCode() {

		baseURI = "https://reqres.in";

		
		given().				//pre-condition : request : POST : body----> format, header
			header("Content-Type", "application/json").
			
		when().
			get("/api/users?page=2").
		
		then().
			statusCode(200).
			body("data[0].email", equalTo("michael.lawson@reqres.in")).
			header("Transfer-Encoding", "chunked").
			header("Content-Type", "application/json; charset=utf-8").
			log().all();
			
			
			

		
	}
	
	
	
	
	

}
