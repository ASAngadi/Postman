package Test2;

/*Different type of Post request body
1) Post request body using Hashmap
2) Post request body creation using Org.json
3) Post request body creation using POJO (Plane Old Java Object) class
4) Post request body creation using external json file
 */

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class DiffWayToCreatePostRequestBody {

	/*1) Post request body using Hashmap*/
	
	@Test(priority=1)
	void testpostusingHashMap()
	
	{
	HashMap hm=new HashMap();
	
	hm.put("name", "Ashu");
	hm.put("location", "France");
	hm.put("phone", "87876999");
	
	String courseArr[]= {"C","C++"};
	hm.put("courses", courseArr);
	
	given()
	    .contentType("application/json")
	    .body(hm)
	    
	.when()
		.post("http://localhost:3000/student")
		
	.then()
		.statusCode(201)
		.body("name",equalTo("Ashu"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("87876999"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
			
	}
	
	/*@Test(priority=2)
	void testDelete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/student/3")
		
		.then()
		  .statusCode(404);
		
		
		
		
	}*/
	
}
