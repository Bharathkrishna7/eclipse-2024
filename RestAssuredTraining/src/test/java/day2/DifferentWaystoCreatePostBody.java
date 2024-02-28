package day2;

import java.util.HashMap;
import static io.restassured.RestAssured.*;

//import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.Test;

public class DifferentWaystoCreatePostBody {

	@Test
	void postUsingHashmap() {
	
	HashMap data=new HashMap();
	data.put("name", "Bharath");
	data.put("location", "banglore");
	data.put("phone", "76567580");
	
	String courseArry[]= {"java","java Script"};
	data.put("courses", courseArry);
	
    given()
	 .contentType("application/json")
	 .body(data)
	.when()
	 .post("http://localhost:3000/student")
	.then()
	 .statusCode(201)
	 .log().all();

	
	}
}
