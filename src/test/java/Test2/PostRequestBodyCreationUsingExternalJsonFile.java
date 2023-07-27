package Test2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.json.*;


import java.io.*;

public class PostRequestBodyCreationUsingExternalJsonFile {
	
	@Test(priority=1)
	void PostRequestJsonFile() throws FileNotFoundException
	{
		File f =new File(".\\body.json");
		
		FileReader fr=new FileReader(f);
		
		JSONTokener jt =new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/student")
	
	
	.then()
		.statusCode(201)
		.body("name",equalTo("Ashu"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("97863440"))
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
	.delete("http://localhost:3000/student/20")
	
	.then()
	.statusCode(404)
	.log().all();
				
	}

}
