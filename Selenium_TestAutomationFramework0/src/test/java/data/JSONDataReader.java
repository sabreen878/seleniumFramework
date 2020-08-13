package data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONDataReader {
	public String firstname, lastname, email, password , productname, name, enquiry;
	
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
		for (Object jsonObj : jArray) {
			
			JSONObject user =  (JSONObject) jsonObj;


			firstname = (String) user.get("firstname");
			System.out.println(firstname);

			lastname = (String) user.get("lastname");
			System.out.println(lastname);

			email = (String) user.get("email");
			System.out.println(email);
			
			password = (String) user.get("password");
			System.out.println(password);
		}

	}
	
	
	public void jsonSearchReader() throws FileNotFoundException, IOException, ParseException {
		
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/SearchProducts.json";
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
		for (Object jsonObj : jArray) {
			
			JSONObject search =  (JSONObject) jsonObj;


			productname = (String) search.get("productname");
			System.out.println(productname);

		}

	}
	
	
	public void jsonContactUsReader() throws FileNotFoundException, IOException, ParseException {
		
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/ContactUsData.json";
	    
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
		for (Object jsonObj : jArray) {
			
			JSONObject contactUs =  (JSONObject) jsonObj;


			name = (String) contactUs.get("name");
			System.out.println(name);

			email = (String) contactUs.get("email");
			System.out.println(email);
			
			enquiry = (String) contactUs.get("enquiry");
			System.out.println(enquiry);
		}
		

	}
}
