package tests;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import testdata.DataBuilder;
import utils.BaseComponent4;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Homework_curs33 extends BaseComponent4 {
	
	String airlineId, passengerId, passengerName, trips, airlineName, country, logo, slogan, head_quarters, website, established;
	
	@Test(priority=1)
	public void createNewAirline() {
		
		Response response = doPostRequest("v1/airlines/", DataBuilder.buildAirline().toJSONString(), 200);
	
		airlineId = response.jsonPath().getString("_id");
		assertThat(airlineId, is(equalTo(response.jsonPath().getString("_id"))));	
		System.out.println(response.asPrettyString());
		
	}
	
	@Test(priority=2)
	public void createPassenger() {
		Response response2 = doPostRequest("v1/passenger/", DataBuilder.buildPassenger().toJSONString(), 200);
		passengerId = response2.jsonPath().getString("_id");
		System.out.println(response2.asPrettyString());
		
	}
	
	@Test(priority=3) 
	public void getPassenger() {
		Response response3 = given().get("v1/passenger/"+passengerId).then().extract().response();
		trips = response3.jsonPath().getString("trips");
		assertThat(trips, is(equalTo(response3.jsonPath().getString("trips"))));
		assertThat(airlineName, is(equalTo(response3.jsonPath().getString("airline[1].name"))));
		System.out.println(response3.asPrettyString());
		
	}	
	
	@Test(priority=4) 
	public void deletePassenger() {
		Response response4 = given().delete("v1/passenger/"+passengerId).then().extract().response();
		System.out.println(response4.asPrettyString());
			
	}
	
}