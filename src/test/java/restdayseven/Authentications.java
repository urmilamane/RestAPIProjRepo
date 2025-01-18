package restdayseven;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {
	
	//@Test
	
	void basicAuthentication() {
		given()
		      .relaxedHTTPSValidation()
		      .auth().basic("postman", "password")
		.when()
		      .get("https://postman-echo.com/basic-auth")
		.then()
		      .statusCode(200)
		      .body("authenticated", equalTo(true))
		      .log().all();
	}
	
	//@Test
	
	void digestAuthentication() {
		given()
		     .relaxedHTTPSValidation()
		     .auth().digest("postman", "password")
		.when()
		     .get("https://postman-echo.com/basic-auth")
		.then()
		     .statusCode(200)
		     .body("authenticated", equalTo(true))
		     .log().all();
		     
		     
	}
	
	//@Test()
	
	void preemptiveAuthentication() {
		given()
		     .relaxedHTTPSValidation() 
		     .auth().preemptive().basic("postman", "password")
		.when()
		     .get("https://postman-echo.com/basic-auth")
		.then() 
		     .statusCode(200)
		     .body("authenticated", equalTo(true))
		     .log().all();
	}
	
	@Test
	
	void bearerTokenAuthentication() {
		
		String beareToken="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";
		given()
		     .headers("Authorization","Bearer "+ beareToken)
		.when()
		      .get("https://api.github.com/user/repos")
	    .then()
		      .statusCode(200)
		      .log().all();
		      
		    
	}
	
	@Test
	
	void testOauth1Authentication() {
		given()
		      .auth().oauth("consumerKey", "consumerSecrate", "accessToken", "TokenSecrate")
		.when()
		      .get("https://api.github.com/user/repos")
		.then()
		      .statusCode(200);
	}
	
	@Test
	
	void testOauth2Authentication() {
	
		given()
		      .auth().oauth2("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")
		.when()
		      .get("https://api.github.com/user/repos")
		.then()
		      .statusCode(200)
		      .log().all();
	}
	
	@Test    
	
	void testAPIKeyAuthentication() throws IOException {
		//Method 1
		/*given()
		     .queryParam("appid", "c04bb9e97c31ef409d584fad50687402")
		.when()
		     .get("http://api.openweathermap.org/geo/1.0/direct?q=Delhi&limit=7")
		.then()
		     .statusCode(200)
		     .log().all();*/
		
		//Method 2
		given()
		     .queryParam("appid", "c04bb9e97c31ef409d584fad50687402")
		     .queryParam("q", "Delhi")
		     .queryParam("limit", "7")
		     .pathParam("mypath", "geo/1.0/direct")
		.when()
		     .get("http://api.openweathermap.org/{mypath}")
		.then()
	         .statusCode(200)
	         .log().all();
	}

}
