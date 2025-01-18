package restdayeight;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUserClass {

	
	@Test
	void testDeleteUser(ITestContext context) {
		String bearerToken="92b38fa575f05f48a4804c975897d0bdd4ba5c4d7d3d2f626aab113cee01f339";
	    int id=(Integer) context.getSuite().getAttribute("user_id");
		try {
		given()
		     .relaxedHTTPSValidation()
		     .contentType("application.json")
		     .headers("Authorization", "Bearer "+bearerToken)
		     .pathParam("id", id)
		.when()
		     .delete("https://gorest.co.in/public/v2/users/(id)")
		.then()
		     .statusCode(204)
		     .log().all();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
