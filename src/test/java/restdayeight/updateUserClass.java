package restdayeight;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateUserClass {

	@Test
	
	void testUpdateUser(ITestContext context) {
		String bearerToken="92b38fa575f05f48a4804c975897d0bdd4ba5c4d7d3d2f626aab113cee01f339";
		Faker faker=new Faker();
		
		JSONObject data= new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().emailAddress());
		data.put("gender", "male");
		data.put("status", "active");
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		
		try {
		given()
		     .relaxedHTTPSValidation()
		     .headers("Authorization","Bearer "+bearerToken)
		     .contentType("application.json")
		     .body(data.toString())
		     .queryParam("id", id)
		  .when()
		      .put("https://gorest.co.in/public/v2/users/(id)")
		  .then()
		      .statusCode(200)
		      .log().all();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
