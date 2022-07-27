package restAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Patch_UpdateUser {
	
	
	@Test
	public void Patch_TC_01_UpdateUser() {
		
		//restassured
		
		String ibm_emp_name = "Abhishek";
		String ibm_emp_job = "leader";
		
		baseURI = "https://reqres.in";
		
		JSONObject request = new JSONObject();
		
		request.put("name", ibm_emp_name);
		request.put("job", ibm_emp_job);
		
		
		//System.out.println(request.toJSONString());
		
		
		given().
			header("Content-Type","application/json").
			header("Accept-Encoding", "gzip, deflate, br").
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			body("name", equalTo(ibm_emp_name)).
			body("job", equalTo(ibm_emp_job)).
			header("Content-Type", "application/json; charset=utf-8").
			header("CF-Cache-Status", "DYNAMIC").
			log().all();
		
		
		
		
		
		
	}
	

}
