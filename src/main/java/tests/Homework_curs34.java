package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Homework_curs34 {

	@Test
	public void hamcrestHomeworkTest() {
		
		Response response = given().get("https://swapi.dev/api/starships/3/").
				then().extract().response();
		
		System.out.println(response.asPrettyString());
		
		JsonPath json = response.jsonPath();

		assertThat(response.asString(), either(containsString("https://swapi.dev/api/films/2"))
				.or(containsString("https://swapi.dev/api/films/6")).or(containsString("https://swapi.dev/api/films/5")));
		
		assertThat(json.getList("pilots"), is((emptyCollectionOf(String.class))));
		
		assertThat(json.getList("films"), is(not(emptyCollectionOf(String.class))));
		
		assertThat(json.getString("model"), both(containsString("Imperial")).and(containsString("Destroyer")));
		
		assertThat(json.getString("name"), is(not(matchesPattern("[a-z 0-9]+"))));
		
		assertThat(json.getString("crew"), is(matchesPattern("[0-9 0-9 , 0-9 0-9 0-9]+")));
		
		assertThat(json.getString("passengers"), is(matchesPattern("[a-z / a-z]+")));
		
		System.out.println(response.asString().length());
		assertThat(response.asString().length(), is(not(lessThan(100)))); 
		
		
		
	
		
	}


}
