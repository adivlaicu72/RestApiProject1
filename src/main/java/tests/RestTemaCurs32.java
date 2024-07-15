package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestTemaCurs32 {

	@Test
	public void restExampleTest() {
		
		Response response = given()
				.headers("Content-Type","application/json")
				.body("{\n"
						+ "    \"id\": 1221,\n"
						+ "    \"idBook\": 1,\n"
						+ "    \"firstName\": \"First Name 1221\",\n"
						+ "    \"lastName\": \"Last Name 1221\"\n"
						+ "}")
				.when()
					.post("https://fakerestapi.azurewebsites.net/api/v1/Authors")
				
				.then()
				.assertThat().statusCode(200).extract().response();
				
				assertTrue(response.asString().contains("1221"));
			
		
		System.out.println(response);
		System.out.println(response.asString());
		System.out.println(response.asPrettyString());
		
		
	}
}
