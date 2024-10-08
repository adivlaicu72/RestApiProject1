package testdata;

import org.json.simple.JSONObject;

import com.github.javafaker.Faker;

import framework.utils.PropertiesFileProcessor;

public class DataBuilder {

	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credential.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credential.properties");

	
	@SuppressWarnings("unchecked")
	public static JSONObject buildUser() {
		
		JSONObject bodyBuilder = new JSONObject();
		Faker fake = new Faker();
		
		bodyBuilder.put("name", fake.name().fullName());
		bodyBuilder.put("email", fake.internet().emailAddress());
		bodyBuilder.put("age", fake.number().numberBetween(5, 130));
		bodyBuilder.put("gender", "m");

		return bodyBuilder;
	}
	@SuppressWarnings("unchecked")
	public static JSONObject buildUpdatedUser() {
		
		JSONObject bodyBuilder = new JSONObject();
		Faker fake = new Faker();
		
		bodyBuilder.put("name", "Test");
		bodyBuilder.put("email", fake.internet().emailAddress());
		bodyBuilder.put("age", "23");
		bodyBuilder.put("gender", "m");

		return bodyBuilder;
	}
	
	
	@SuppressWarnings("unchecked")
	public static JSONObject buildToken() {
		
		String USER = PropertiesFileProcessor.readPropertiesFile("user", "credential.properties");
		String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credential.properties");
		
		JSONObject tokenBuilder = new JSONObject();
		tokenBuilder.put("user", USER);
		tokenBuilder.put("pass", PASS);
		
		return tokenBuilder;
				
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject buildTodo() {
		Faker fake =  new Faker();
		JSONObject todoBuilder = new JSONObject();
		todoBuilder.put("title", fake.name().fullName());
		todoBuilder.put("body", fake.address().fullAddress());
		
		return todoBuilder;
				
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject buildAirline() {
		JSONObject airLineBuilder = new JSONObject();
		airLineBuilder.put("name", "Tarom");
		airLineBuilder.put("country", "Romania");
		airLineBuilder.put("logo", "https://commons.wikimedia.org/wiki/File:TAROM_Logo_tail.svg");
		airLineBuilder.put("slogan", "From Romania");
		airLineBuilder.put("head_quaters", "Bucharest Romania");
		airLineBuilder.put("website", "www.tarom.com");
		airLineBuilder.put("etablished", "1990");
		
		return airLineBuilder;
				
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject buildPassenger() {
		
		JSONObject bodyBuilder = new JSONObject();
		Faker fake = new Faker();
		
		bodyBuilder.put("name", fake.name().fullName());
		bodyBuilder.put("trips", 250);
		bodyBuilder.put("airline", "f47c420c-390d-4714-9f96-79c13330ec04");

		return bodyBuilder;
	}
	
	
	
}