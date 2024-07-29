package utils;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseComponent2 {

		@BeforeClass
		public void setup() {
			
			RestAssured.baseURI="https://api.instantwebtools.net/";
			
		}
		
		public static Response doPostRequest(String path, String reqBody, int statusCode) {
			
			Response response = given().
									contentType(ContentType.JSON).
									body(reqBody).
								when().	
									post(path). 
								then(). 
									statusCode(statusCode). 
									extract().response();
			return response;
			
	}
}

