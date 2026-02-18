package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;


import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class TestExample {
	
	@Test
	public void test1() {
		
		
		Response response =
		
		
		RestAssured.get("http://localhost:3000/students/1");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		 response.then()
         .assertThat()
         .statusCode(200)
         .body(matchesJsonSchemaInClasspath("schema.json"));
		 
		 
		 
		 List<String> subjects = response.jsonPath().getList("subjects");

		 Assert.assertEquals(subjects.size(), 3);
		 Assert.assertTrue(subjects.contains("Computer Science"));
}



@Test
public void test2() {
	
	
	Response response =
	
	
	RestAssured.get("http://localhost:3000/students/125");
	
	 response.then()
     .assertThat()
     .statusCode(404)
     .body(equalTo("Not Found"));
}

@Test

public void test3() {
	
	
	 RestAssured.baseURI = "http://localhost:3000";

     // Prepare request body as Map
     Map<String, Object> requestBody = new HashMap<>();
     requestBody.put("name", "Rahul Singh");
     requestBody.put("age", 16);
     requestBody.put("grade", "10th");
     requestBody.put("subjects", Arrays.asList("Computer Science", "Philosophy", "Art"));

     // Send POST request
     Response response = given()
             .header("Content-Type", "application/json")
             .body(requestBody)
             .when()
             .post("/students")
             .then()
             .statusCode(201) // Created
             .body("name", equalTo("Rahul Singh"))
             .body("age", equalTo(16))
             .body("grade", equalTo("10th"))
             .body("subjects", hasSize(3))
             .body("subjects", hasItems("Computer Science", "Philosophy", "Art"))
             // JSON schema validation (studentSchema.json in src/test/resources)
            .body(matchesJsonSchemaInClasspath("schemaput.json"))
             .extract().response();

     // Print response
     System.out.println("POST Response:\n" + response.getBody().asString());
 }

@Test

public void test4() {
	
	
	 // Base URI inside the method
    RestAssured.baseURI = "http://localhost:3000";

    // Full JSON object for PUT
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("id", "2");
    requestBody.put("name", "Jane Smith");
    requestBody.put("age", 17);
    requestBody.put("grade", "PostDoc");
    requestBody.put("subjects", Arrays.asList("Biology", "Chemistry", "History"));

    // Send PUT request
    Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .put("/students/2")
            .then()
            .statusCode(200) // success
            .body("id", equalTo("2"))
            .body("name", equalTo("Jane Smith"))
            .body("age", equalTo(17))
            .body("grade", equalTo("PostDoc"))
            .body("subjects", hasItems("Biology", "Chemistry", "History"))
            .body("subjects", hasSize(3))
            .extract().response();

    // Print response
    System.out.println("PUT Response:\n" + response.getBody().asString());
	
}


@Test
public void test5()
{
	
	 // Base URI inside method
    RestAssured.baseURI = "http://localhost:3000";

    // Step 1: Prepare POST data
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("name", "Rahul Singh");
    requestBody.put("age", 16);
    requestBody.put("grade", "10th");
    requestBody.put("subjects", Arrays.asList("Astronomy"));

    // Step 2: POST request to create student
    Response postResponse = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .post("/students")
            .then()
            .statusCode(201) // Created
            .body("name", equalTo("Rahul Singh"))
            .body("age", equalTo(16))
            .body("grade", equalTo("10th"))
            .body("subjects", hasItem("Astronomy"))
            .extract().response();

    // Extract the dynamic ID
    String studentId = postResponse.jsonPath().getString("id");

    System.out.println("Created student 'Rahul Singh' with ID: " + studentId);

    // Step 3: DELETE request using dynamic ID
    given()
            .when()
            .delete("/students/" + studentId)
            .then()
            .statusCode(200); // JSON server returns 200 on delete

    System.out.println("Deleted student 'Rahul Singh' with ID: " + studentId);

    // Step 4: Verify deletion
    given()
            .when()
            .get("/students/" + studentId)
            .then()
            .statusCode(404); // Student no longer exists
	
	
	
	
	
	
	
	
	
	
	
}














}




















