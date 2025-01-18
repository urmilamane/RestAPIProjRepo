package resydayfive;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;


public class UploadFileResponse {
	@Test
	
	void testFileUpload() {
		File myfile= new File("C:\\Users\\urmane\\Documents\\API testing.txt");
		given()
		     .relaxedHTTPSValidation()
		     .multiPart("file",myfile)
		     .contentType("multipart/form.data")
		    
		.when()
		     .post("https://v2.convertapi.com/upload")
		.then()
		     .statusCode(200)
		     .body("FileName",equalTo("API testing.txt"))
		     .log().all();
	}
}
