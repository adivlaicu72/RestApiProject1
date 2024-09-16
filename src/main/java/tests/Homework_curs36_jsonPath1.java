package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Homework_curs36_jsonPath1 {
	
	@Test
	public void temaJsonPath() {
		
		Response response = given().get("https://fakerestapi.azurewebsites.net/api/v1/Books/")
				.then().extract().response();
		
		System.out.println(response.asString());
		
		JsonPath json = response.jsonPath();
		
		System.out.println(json.getString("id.size()"));
		
		List<String> allBooks = json.getList("findAll{it.pageCount > 1000 & it.pageCount < 2000}.pageCount");
		System.out.println(allBooks);
		System.out.println(allBooks.size());
		assertThat(allBooks, hasSize(9));
	}
}
