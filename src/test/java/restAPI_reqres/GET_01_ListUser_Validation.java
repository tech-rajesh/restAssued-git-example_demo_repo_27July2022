package restAPI_reqres;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_01_ListUser_Validation {

	Response response;
	
	@BeforeTest
	public void setup() {

		RestAssured.baseURI = "https://reqres.in";

		// Request - precondition - format, header
		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// send a request
		response = httpRequest.request(Method.GET, "/api/users?page=2"); // send a request
	}

	@Test
	public void verifyStatusCode() {

		int actualStatusCode = response.getStatusCode();
		System.out.println("Status Code: " + actualStatusCode);
		Assert.assertEquals(actualStatusCode, 200);

	}
	
	@Test
	public void verifyContentType() {

		String actualContentType = response.getContentType();
		System.out.println("ContentType: " + actualContentType);
		Assert.assertEquals(actualContentType, "application/json; charset=utf-8");
		
		Assert.assertTrue(actualContentType.contains("application/json"));

	}
	
	@Test
	public void verifyResponseTime() {

		long actualResponseTime = response.getTime();
		System.out.println("ResponseTime: " + actualResponseTime);
		

	}
	
	@Test
	public void verifyResponseBodyValue() {

		String actualResponseBody = response.getBody().asPrettyString();
		System.out.println("ResponseBody: " + actualResponseBody);
		Assert.assertTrue(actualResponseBody.contains("lindsay.ferguson@reqres.in"));

	}
	

}
