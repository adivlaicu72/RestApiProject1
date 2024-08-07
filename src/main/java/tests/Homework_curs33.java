package tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import testdata.DataBuilder;
import utils.BaseComponent5;

public class Homework_curs33 extends BaseComponent5{
	
	String name, country, logo, slogan, head_quaters, website, established, id;
	

	//@Test(priority=1)
	public void createNewAirline() {
		
		Response response = doPostRequest("v1/airlines", DataBuilder.buildAirline().toJSONString(), 200);
	
		assertThat(name, is(equalTo(response.jsonPath().getString("result.name"))));
		
		name = response.jsonPath().getString("result.name");
		country = response.jsonPath().getString("result.country");
		logo = response.jsonPath().getString("result.logo");
		slogan = response.jsonPath().getString("result.slogan");
		head_quaters = response.jsonPath().getString("result.head_quaters");
		website = response.jsonPath().getString("result.website");
		established = response.jsonPath().getString("result.established");
		id = response.jsonPath().getString("result._id");
		
		System.out.println(response.asPrettyString());
		
	}
	
	@Test(priority=2)
	public void createNewPassenger() {
		Response response = doPostRequest("v1/passenger" +id, DataBuilder.buildUser().toJSONString(), 200);
		
		System.out.println(response.asPrettyString());
	}
	
	
	
}
