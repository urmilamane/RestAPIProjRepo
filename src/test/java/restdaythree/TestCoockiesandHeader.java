package restdaythree;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class TestCoockiesandHeader {
	
    //@Test(priority=1)
	void testCookies()
	{
		given()
		     .relaxedHTTPSValidation()
		.when()
		     .get("https://www.google.com/")
		.then()
		     .cookie("AEC","AVYB7cpqoFO8dPz3tJ_FHHLmg-TLt3WD8Jb6XxUsTylwyY3_LxLdams9mrg")
		     .log().all();
		    
	}
	
	@Test(priority=2)
	void getCookies() 
	{
		
     Response res=  given()
		                  .relaxedHTTPSValidation()
		
		             .when()
		                  .get("https://www.google.com/");
     //get single cookie info
       
    // String cookie_value = res.getCookie("AEC");
    // System.out.println("Value of the cookie is =="+cookie_value);
     
     //get all cookies info
     
     Map<String, String> cookies_values= res.getCookies();
     System.out.println(cookies_values.keySet());
     
     for(String k:cookies_values.keySet()) {
    	 String cookie_value= res.getCookie(k);
    	 System.out.println(k+"  "+cookie_value);
     }
	}

}
