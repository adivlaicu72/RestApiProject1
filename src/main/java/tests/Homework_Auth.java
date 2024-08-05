package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class Homework_Auth {

	@Test
	public void bearerAuth() {
		
		Response responseToken = given(). 
				contentType(ContentType.JSON). 
				body("{\"user\":\"admin\",\"pass\": \"admin@123\"}"). 
				post("https://dev-todo-b369f85c9f07.herokuapp.com/api/login")
				.then().extract().response();
				
		String token = responseToken.jsonPath().getString("token");
		//String id = responseToken.jsonPath().getString("user._id");
		
		assertThat(token, is(not(nullValue())));
		//assertThat(id, is(not(nullValue())));
		
		System.out.println(responseToken.asPrettyString());
		
		
		
		Response responseProfile = given(). 
				//auth().oauth2(token).
				header("Authorization", "Bearer " + token).
				get("https://dev-todo-b369f85c9f07.herokuapp.com/api/api/profile"). 
				then().extract().response();
		
		System.out.println(responseProfile.asPrettyString());
		
	}
}
