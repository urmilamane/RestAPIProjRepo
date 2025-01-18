package restdaythree;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestHeaderClass {

	@Test(priority=1, enabled=true)
	
	void testHeader()
	{
		given()
		     .relaxedHTTPSValidation()
		  .when()
		       .get("https://www.google.com/")
		  .then()
		       .header("Content-Type", "text/html; charset=ISO-8859-1")
		       .header("Content-Encoding", "gzip")
		       .and()
		       .header("Server", "gws")
		       .log().all();
		  
	}
	
	//@Test(priority=2)
	
	void getHeaders() {
		
	  Response res=	 given()
		     .relaxedHTTPSValidation()
		  .when() 
		      .get("https://www.google.com/");
	  
	  //get single header value
	  String header_Value= res.getHeader("Content-Type");
	  System.out.println("Header value is " +header_Value);
	  
	  //get all headers values
	  
		  
	  Headers myheaders= res.getHeaders();
	  
	  for(Header hd: myheaders) {
		  System.out.println(hd.getName()+"   "+ hd.getValue());
	  }
		     
	}
}
