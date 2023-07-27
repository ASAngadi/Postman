package Test2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class PostRequestBodyCreationUsingPOJO {
	
	@Test(priority=1)
	void testPostPojo()
	{
		POJO_PostRequest data=new POJO_PostRequest();
		data.setName("Ashu");
		data.setLocation("France");
		data.setPhone("899971333");
		String coursesArr[]= {"C","C++"};
		data.setCourses(coursesArr);
		
		given()
		      .contentType("application/json")
		      .body(data)
		
		.when()
			.post("http://localhost:3000/student")
		
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Ashu"))
			.body("location",equalTo("France"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		
		
	}

	
	@Test(priority=2)
	void Delete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/student/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	

}
