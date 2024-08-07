package utils;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseComponent5 {

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
		public static Response doPatchRequest(String path, String body) {
			
			Response response = given().
					body(body).
				when().	
					patch(path). 
				then(). 
					extract().response();
				return response;
			
		}
		
	public static Response doGetRequest(String path) {
		
		Response response = given().
			when().	
				get(path). 
			then(). 
				extract().response();
			return response;
		
	}
	public static Response doDeleteRequest(String path) {
		
		Response response = given().
			when().	
				delete(path). 
			then(). 
				extract().response();
			return response;
		
	}
}

