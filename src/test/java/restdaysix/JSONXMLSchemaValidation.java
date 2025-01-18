package restdaysix;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator; 

public class JSONXMLSchemaValidation {

	 @Test
	 
	 void TestJSONSchema() {
		 given()
		      
		 .when()
		      .get("https://api.restful-api.dev/objects")
		 .then()
		      .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
	 }
}
