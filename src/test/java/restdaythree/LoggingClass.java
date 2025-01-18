package restdaythree;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class LoggingClass {

	
	@Test
	
	void testLogs() {
		given()
		
		.when()
		     .get("https://restful-api.dev/")
		.then()
		     .log().body()
		     .log().cookies()
		     .log().headers();
	}
}
