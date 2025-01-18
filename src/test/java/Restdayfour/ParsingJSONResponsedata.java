package Restdayfour;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponsedata {

	@Test(priority=1, enabled= false)
	
	void testJsonResponse() {
		
		//Approach1
		/*given()
		     .contentType("ContentType.json")
		  .when()
		       .get("https://api.restful-api.dev/objects?id=1")
		  .then()
		       .statusCode(200)
		      // .body("name", equalTo("Google Pixel 6 Pro"))
		      // .body("data[0].color","Cloudy White")
		       .header("Content-Type", "application/json")
		       .log().all();  */
		
		//Approach 2
		
		 Response res= given()
		                   .contentType("ContentType.JSON")
		                .when()
		                   .get("https://api.restful-api.dev/objects?id=1");
		 Assert.assertEquals(res.getStatusCode(),200);
		 Assert.assertEquals(res.getContentType(), "application/json");
		 
		 String name= res.jsonPath().get("name").toString();
		 Assert.assertEquals(name, "Google Pixel 6 Pro");
		                 
		         
	}
	
@Test(priority =2)
	
	void testJsonResponseBodyData() {
		
		//Approach1
		/*given()
		     .contentType("ContentType.json")
		  .when()
		       .get("https://api.restful-api.dev/objects?id=1")
		  .then()
		       .statusCode(200)
		      // .body("name", equalTo("Google Pixel 6 Pro"))
		      // .body("data[0].color","Cloudy White")
		       .header("Content-Type", "application/json")
		       .log().all();  */
		
		//Approach 2
		
		 Response res= given()
		                   .contentType(ContentType.JSON)
		                .when()
		                   .get("https://api.restful-api.dev/objects");
		 Assert.assertEquals(res.getStatusCode(),200);
		 Assert.assertEquals(res.getContentType(), "application/json");
		 
		JSONArray array= new JSONArray(res.body().asString());
		Assert.assertEquals(array.getJSONObject(0).getString("name"), "Google Pixel 6 Pro");
		Assert.assertEquals(array.getJSONObject(0).getJSONObject("data").getString("color"), "Cloudy White");
		
		Boolean status=false;
			for(int i=0; i<array.length();i++) 
			{
				String names=array.getJSONObject(i).getString("name");
				System.out.println(names);
				
				if(names.equals("Google Pixel 6 Pro"))
				{
					status=true;
					break;
					
				}
		    }
		
		 Assert.assertEquals(true, status);
		
	
  }
}