package tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Homework_curs36_jsonPath2 {

	@Test
	public void parseJson() throws IOException, ParseException{
		//1.parser de json
		JSONParser parserObj = new JSONParser();
		//2. incarcam fisierul json
		FileReader reader = new FileReader("data4.json");
		//3. parserul primeste fisierul
		
		Object obj = parserObj.parse(reader);
		//4. punem contintul intr-un json array
		JSONArray peopleList = (JSONArray) obj;
		System.out.println(peopleList);	
		//5 citim un JsonObject din Json Array
		//JSONObject peopleObject = (JSONObject) peopleObject.get(0);
		//System.out.println(peopleObject);
		
		/*
		String employeeAttributeDate = (String) employeeObject.get("date");
		System.out.println(employeeAttributeDate);
		
		JSONObject employeeAttribute = (JSONObject) employeeObject.get("employee");
		System.out.println(employeeAttribute);
		
		System.out.println(employeeAttribute.get("company"));
		System.out.println(employeeAttribute.get("firstName"));
		
		System.out.println("---------------------------------------------");
		
		File jsonFile = new File("data3.json");
		JsonPath jsonPath = JsonPath.from(jsonFile);
		
		System.out.println(jsonPath.getString("[0]"));
		System.out.println(jsonPath.getString("[0].employee.company"));
		*/
	}
}
