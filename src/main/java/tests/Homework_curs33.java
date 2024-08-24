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
	
		airlineId = response.jsonPath().getString("result._id");
		airlineName = response.jsonPath().getString("result.name");
		country = response.jsonPath().getString("result.country");
		logo = response.jsonPath().getString("result.logo");
		slogan = response.jsonPath().getString("result.slogan");
		head_quarters = response.jsonPath().getString("result.head_quarters");
		website = response.jsonPath().getString("result.website");
		established = response.jsonPath().getString("result.established");
		assertThat(airlineId, is(equalTo(response.jsonPath().getString("result._id"))));	
		System.out.println(response.asPrettyString());
		
	}
	
	@Test(priority=2)
	public void createPassenger() {
		Response response2 = doPostRequest("v1/passenger/", DataBuilder.buildPassenger().toJSONString(), 200);
		System.out.println(response2.asPrettyString());
		
	}
	
	@Test(priority=3) 
	public void getPassenger() {
		Response response3 = given().get("v1/passenger/"+passengerId).then().extract().response();
		assertThat(trips, is(equalTo(response3.jsonPath().getString("trips"))));
		assertThat(airlineName, is(equalTo(response3.jsonPath().getString("result.name"))));
		System.out.println(response3.jsonPath().getString("result._id"));

		
	}
	
	
	//@Test(priority=4) 
	public void deletePassenger() {
		Response response4 = given().delete("v1/passenger/"+passengerId).then().extract().response();
		System.out.println(response4.asPrettyString());
			

	}



	
}