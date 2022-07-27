package restAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Patch_UpdateUser2 {
	
	
	@Test
	public void PUT_TC_01_UpdateUser_test() {
		
		
		baseURI = "https://reqres.in";
		
		String name = "Abhishek";
		String job = "leader";
		
		JSONObject requestBody = new JSONObject();
		
		
		requestBody.put("name", name);
		requestBody.put("job", job);
		
		//System.out.println("Body: " + requestBody.toJSONString());
		
		
		
		
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(requestBody.toJSONString()).

		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			body("name", equalTo(name)).
			header("CF-Cache-Status", "DYNAMIC").
			log().all();
		
		
		
		
	}

}
