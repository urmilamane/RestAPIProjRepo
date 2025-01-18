package restdayeight;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUserdataClass {

	@Test
	
	void testGetUser(ITestContext context) {
		int id=(Integer) context.getSuite().getAttribute("user_id");
		System.out.println("id is: "+id);
		String bearerToken="92b38fa575f05f48a4804c975897d0bdd4ba5c4d7d3d2f626aab113cee01f339";
		try {
		given()
		     .headers("Authorization","Bearer "+bearerToken)
		     .queryParam("id", id)
		  .when()
		     .get("https://gorest.co.in/public/v2/users/(id)")
		  .then()
		     .statusCode(200)
		     .log().all();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
