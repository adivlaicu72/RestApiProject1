package utils;

import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseComponent3 {

	String token;
	public static RequestSpecification requestSpec;
	public static ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setup() {
		
		requestSpec = new RequestSpecBuilder().
				setContentType(ContentType.JSON).
				setBaseURI("https://dev-todo-b369f85c9f07.herokuapp.com/").
				setBasePath("api/").
				addHeader("Authorization", "Bearer " +token).
				addHeader("accept, "application/json").build();"
						
		responseSpec = new SpecBuilder().
			expectStatusCode
					
	}
	
}
