package tests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import testdata.DataBuilder;
import utils.BaseComponent3;

public class Homework_curs33 extends BaseComponent3{
	
	String name, country, logo, slogan, head_quaters, website, established;
	

	@Test(priority=1)
	public void createNewAirline() {
		
		Response response = doPostRequest("v1/airlines", DataBuilder.buildAirline().toJSONString(), 200);
	
		assertThat(response.jsonPath().getString("success"), is("true"));
		
		name = response.jsonPath().getString("result.name");
		country = response.jsonPath().getString("result.country");
		logo = response.jsonPath().getString("result.logo");
		slogan = response.jsonPath().getString("result.slogan");
		head_quaters = response.jsonPath().getString("result.head_quaters");
		website = response.jsonPath().getString("result.website");
		established = response.jsonPath().getString("result.established");
		
		System.out.println(response.asPrettyString());
		
	}
}
