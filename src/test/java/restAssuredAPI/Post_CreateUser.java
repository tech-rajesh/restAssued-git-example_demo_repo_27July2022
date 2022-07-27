package restAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Post_CreateUser {
	
	
	@Test(dataProvider = "smokeTest")
	public void Post_TC_01_CreateUser(String ibm_emp_name, String ibm_emp_role) throws Exception {
		
		//restassured
		
//		String ibm_emp_name = "Abhishek";
//		String ibm_emp_job = "leader";
		
		baseURI = "https://reqres.in";
		
		JSONObject request = new JSONObject();
		
		request.put("name", ibm_emp_name);
		request.put("job", ibm_emp_role);
		
		
		//System.out.println(request.toJSONString());
		
		
		given().
			header("Content-Type","application/json").
			header("Accept-Encoding", "gzip, deflate, br").
			body(request.toJSONString()).
		when().
			post("/api/users").
		then().
			statusCode(201).
			body("name", equalTo(ibm_emp_name)).
			body("job", equalTo(ibm_emp_role)).
			header("Content-Type", "application/json; charset=utf-8").
			header("CF-Cache-Status", "DYNAMIC").
			log().all();
		
		System.out.println("=====================================================");
		System.out.println("=====================================================");
		Thread.sleep(4000);
	}
	
	
	@DataProvider(name = "smokeTest")
	public Object[][] smokeData() {
		
		Object [][] data = {{"user1", "leader"}, {"user2", "sr. leader"}, {"user3","sr. manager"}};
		return data;
	}
	

}
