package restdayeight;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

public class ChainingClass {

	@Test
	void testcreateUser(ITestContext context)
	{
		Faker faker= new Faker();
		JSONObject data= new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "Inactive");
		
		String bearerToken="92b38fa575f05f48a4804c975897d0bdd4ba5c4d7d3d2f626aab113cee01f339";
		
		int id= given()
				    .relaxedHTTPSValidation()
			     	.headers("Authorization", "Bearer "+bearerToken)
			    	.contentType("application/json")
				    .body(data.toString())
				.when()
				     .post("https://gorest.co.in/public/v2/users")
				     .jsonPath().getInt("id");
		System.out.println("Generated ID is: "+id);
		
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
		
	}
	
}
