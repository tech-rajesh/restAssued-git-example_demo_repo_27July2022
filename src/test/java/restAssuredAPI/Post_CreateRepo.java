package restAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Post_CreateRepo {
	
	
	@Test
	public void Post_TC_01_CreateUser() {
		
		//restassured
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "recap_git_demo_20220727_1");
		//request.put("job", ibm_emp_job);
		
		
		//System.out.println(request.toJSONString());
		
		
		given().
			header("Content-Type","application/json").
			auth().oauth2("").
			//header("Accept-Encoding", "gzip, deflate, br").
			body(request.toJSONString()).
		when().
			post("https://api.github.com/user/repos").
		then().
			statusCode(201).
			body("name", equalTo("recap_git_demo_20220727_1")).
			//header("Content-Type", "application/json; charset=utf-8").
			//header("CF-Cache-Status", "DYNAMIC").
			log().all();
		
		
	}
	
	
	@DataProvider(name = "smokeTest")
	public void smokeData() {
		
		
	}
	

}
