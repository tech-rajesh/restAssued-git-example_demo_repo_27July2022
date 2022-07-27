package restAPI_reqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_01_ListUser {
	
	
	@Test
	public void verifyListUserTest() {
		
		RestAssured.baseURI= "https://reqres.in";
		
		//Request - precondition - format, header
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//send a request
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");			//send a request
		
		//System.out.println(response.getBody().asString());
		System.out.println(response.getBody().asPrettyString());
		
		
		//validation 
		int actualStatusCode = response.getStatusCode();
		System.out.println("Status Code: " + actualStatusCode);
		Assert.assertEquals(actualStatusCode, 200);
		
	}
	

}
