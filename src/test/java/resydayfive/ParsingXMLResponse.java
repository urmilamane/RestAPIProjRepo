package resydayfive;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingXMLResponse {

	
	//@Test()
	void testXMLResponse() {
		given()
		      .relaxedHTTPSValidation()
		 .when()
		      .get("https://mocktarget.apigee.net/xml")
		 .then()
		      .statusCode(200)
		      .header("Content-Type", "application/xml; charset=utf-8")
		      .body("root.city", equalTo("San Jose"))
		      .log().all();
		
	}
	
	@Test()
	void testXMLResponseBody() {
	  Response res=	 given()
		            .relaxedHTTPSValidation()
		  .when()
		      .get("https://mocktarget.apigee.net/xml");
		  
	  Assert.assertEquals(res.getStatusCode(), 200);
	  Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		      
	}
	
}
