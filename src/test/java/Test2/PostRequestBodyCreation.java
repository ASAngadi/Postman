package Test2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class PostRequestBodyCreation {
	
	@Test(priority=1)
	void PostRequestBodyUsingJSON()
	{
		JSONObject data=new JSONObject();
		data.put("name", "Ashu");
		data.put("location", "France");
		data.put("phone", "2334455");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/student")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Ashu"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("2334455"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}

	@Test(priority=2)
	void Delete() {
		
		given()
		
		.when()
		.delete("http://localhost:3000/student/3")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
