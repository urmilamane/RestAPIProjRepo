package resrdaysecond;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

@Test
public class WaystocreateBody {
 
	//1)Post approach by using HashMap
	//@Test(priority=1)
	void testPostUsingHashMap() {
		HashMap<String, Object> data =new HashMap<String, Object>();
		data.put("name", "Urmila");
		data.put("location", "Pune");
		data.put("phone","23456789");
		String courseArr[]= {"C","C++"};
		data.put("courses",courseArr);
		
		given()
		     .contentType("application/json")
		     .body(data)
		.when()
             .post("https://reqres.in/api/users")
        .then()
             .statusCode(201)
             .body("name", equalTo("Urmila"))
             .body("location", equalTo("Pune"))
             .body("phone",equalTo("234567"))
             .body("courses[0]",equalTo("C"))
             .body("courses[1]",equalTo("C++"))
             .header("Content-type", "application/json; charset=utf-8")
             .log().all();
	}

	//2)Post approach by using org.JSON
	//@Test(priority=2)
	
	void testPostusingJsonLibrary() {
		JSONObject data= new JSONObject();
		data.put("name","Praveen");
		data.put("location","Pune");
		data.put("phone","127890");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		given()
		     .contentType("application/json")
		     .body(data.toString())
		.when()
             .post("https://reqres.in/api/users")
        .then()
             .statusCode(201)
             .body("name", equalTo("Praveen"))
             .body("location", equalTo("Pune"))
             .body("phone",equalTo("127890"))
             .body("courses[0]",equalTo("C"))
             .body("courses[1]",equalTo("C++"))
             .header("Content-type", "application/json; charset=utf-8")
             .log().all();
	}
	//@Test(priority=3)
	void deleteUser() {
		given()
		
		.when()
		     .delete("https://reqres.in/api/users/936")
		.then()
		     .statusCode(204)
		     .log().all();
	}

	//3)Post approach by using POJO class
	//@Test(priority=4)
	
	void testPostusingPojo() {
		Pojo_postrequest data= new Pojo_postrequest();
		data.setName("Praveen");
		data.setLocation("Mumbai");
		data.setPhone("567890");
		String courseArr[]={"C","C++"};
		data.setCourses(courseArr);
		
		
		given()
	     .contentType("application/json")
	     .body(data)
	   .when()
         .post("https://reqres.in/api/users")
       .then()
         .statusCode(201)
         .body("name", equalTo("Praveen"))
         .body("location", equalTo("Mumbai"))
         .body("phone",equalTo("567890"))
         .body("courses[0]",equalTo("C"))
         .body("courses[1]",equalTo("C++"))
         .header("Content-type", "application/json; charset=utf-8")
         .log().all(); 
		
		
	}
	
	//Post approach by using external JSON file
	@Test(priority=5)
	void testPostusingExternalJsonFile() throws FileNotFoundException {
		File file= new File(".\\body.json");
		FileReader filereader= new FileReader(file);
		JSONTokener jt= new JSONTokener(filereader);
		JSONObject data= new JSONObject(jt);
		
		given()
		     .contentType("application/json")
		     .body(data.toString())
		.when()
		     .post("https://reqres.in/api/users")
		.then()
		     .statusCode(201)
		     .body("name",equalTo("Pragyan"))
		     .body("location",equalTo("Sangli"))
		     .body("phone",equalTo("897605"))
		     .body("courses[0]",equalTo("C"))
		     .body("courses[1]",equalTo("C++"))
		     .log().all();
		
	}
	
}
