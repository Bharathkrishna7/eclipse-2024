package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
given()
  Here we take pre-request like "Content-type,set cookies,add auth,add param,set headers" e.t.c....
            
When()
 Here we use methods like "get,Post.put,Patch, delete"
 
Then()
 Here we do Valid "status code,extract response,extract headers,cookies & response body"....
                   
 */

public class HttpRequests {

	int id; 
		@Test(priority=1)
	 void getusers() {
	given()
		//from second method we have to specify "."
		 .when()
		  .get("https://reqres.in/api/users?page=2")
		
	.then()
		 .statusCode(200)
		 .body("page",equalTo(2))
		 .log().all();
	}
	 
	@Test(priority=2)
	void createUser() {
		
	HashMap data=new HashMap();
	data.put("name", "krishna");
	data.put("job", "QA");
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");
		 
//		.then()
//		  .statusCode(201)
//		  .log().all();
		
	}
    
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser() {
		HashMap data=new HashMap();
		data.put("name", "Bharath");
		data.put("job", "SDET");
			
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			   .put("https://reqres.in/api/users/"+id)
			   
			   .then()
			     .statusCode(200)
			     .log().all();
	}
	
	@Test(priority=4,dependsOnMethods= {"updateUser"})
	void deleteUser() {
		
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
		
		
	}
}
