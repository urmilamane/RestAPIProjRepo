package restdayfirst;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {
	int Id;
	
   @Test(priority=1)
   void getUsers() {
	  given()
		  
	   
	   .when()
	     .get("https://reqres.in/api/users?page=2")
	   .then()
	     .statusCode(200)
	     .body("page",equalTo(2))
	     .log().all();
   }
	
	@Test(priority=2)
	void createUser() {
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("name", "urmila");
		data.put("job", "tester");
		
		Id=given()
		     .contentType("application/json")
		     .body(data)
		.when()
		     .post("https://reqres.in/api/users")
		     .jsonPath().getInt("id");
//		.then()
//		     .statusCode(201)
//		     .log().all();
	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser() {
		HashMap<String, String> data= new HashMap<String, String>();
		data.put("name", "Praveen");
		data.put("job", "Developer");
		
		given()
		     .contentType("application/json")
		     .body(data)
		     
		.when()
		     .put("https://reqres.in/api/users/" + Id)
		     
		.then()
		     .statusCode(200)
		     .log().all();
	}
	
	@Test(priority=4,dependsOnMethods= { "createUser"})
	void deleteUser() {
		given()
		
		.when()
		     .delete("https://reqres.in/api/users/"+ Id)
		.then()
		     .statusCode(204)
		     .log().all();
	}
	
}
