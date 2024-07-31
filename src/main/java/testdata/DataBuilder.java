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
		
		JSONObject tokenBuilder = new JSONObject();
		tokenBuilder.put("user", tokenBuilder);
		tokenBuilder.put("user", tokenBuilder);
		
		return tokenBuilder;
				
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject buildToDo() {
		Faker fake = new Faker();
		JSONObject todoBuilder = new JSONObject();
		todoBuilder .put("title", fake.name().fullName());
		todoBuilder .put("body", fake.address().fullAddress());
		
		return todoBuilder;
				
	}
	
}