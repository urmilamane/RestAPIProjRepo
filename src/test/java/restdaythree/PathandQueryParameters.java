package restdaythree;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathandQueryParameters {
	
	@Test
	
	void testQueryandPathParameters() {
		given()
		      .pathParam("mypath","users")
		      .queryParam("page", 2)
		      .queryParam("id", 5)
		 .when()
		      .get("https://reqres.in/api/{mypath}")
		 .then()
		      .statusCode(200)
		      .log().all();
	}
	

}
