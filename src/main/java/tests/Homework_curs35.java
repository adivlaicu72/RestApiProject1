package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static utils.NumberChecker.numbersOnly;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Homework_curs35 {

	@Test
	public void hamcrestHomework35Test() {
		
		Response response = given().get("https://swapi.dev/api/people/1/").
				then().extract().response();
		
		System.out.println(response.asPrettyString());
		
		JsonPath json = response.jsonPath();
			
		// Verificam ca numele este Luke Skywalker
		String name = json.getString("name");
		System.out.println(name);
		assertThat(name, equalTo("Luke Skywalker"));
		//Verificam ca height este mai mare ca 171
		Integer height = json.getInt("height");
		System.out.println(height);
		assertThat(height, greaterThan(171));
		//Verificam ca mass este mai mic decat 80
		Integer mass = json.getInt("mass");
		System.out.println(mass);
		assertThat(mass, lessThan(80));
		//Intr-un singur assert vom verifica daca valorile atributelor skin_color, eye_color si hair_color sunt fair, blue si blond
		System.out.println("------------------------------------------------------");
		String[] array = {json.getString("skin_color"), json.getString("eye_color"), json.getString("hair_color")};
		System.out.println(Arrays.toString(array));
		assertThat(array, arrayContaining("fair", "blue", "blond" ));
		//Verificam daca birth_year nu este o valoare doar numerica
		assertThat(json.getString("birth_year"), is(matchesPattern("[0-9 0-9 A-Z A-Z A-Z]+")));
		//or
		assertThat(json.getString("birth_year"), is(not(numbersOnly())));
		
		List<String> starships = json.getList("starships");
        List<String> vehicles = json.getList("vehicles");
        List<String> species = json.getList("species");
        //Verificam ca species este o colectie goala a clasei String
        assertThat(species, is((emptyCollectionOf(String.class))));
		//Verificam ca starship si vehicles au acealsi size
        assertThat(starships, hasSize(2));
        assertThat(vehicles, hasSize(2));
        
        //Verificam ca starship si vehicles nu sunt la fel
        assertThat(starships, hasItems("https://swapi.dev/api/starships/12/", "https://swapi.dev/api/starships/22/"));
        assertThat(vehicles, hasItems("https://swapi.dev/api/vehicles/14/", "https://swapi.dev/api/vehicles/30/"));
		
	
	}
}