package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	ContactUsPage contactUsObject;
	HomePage homeObject;
	
	@Test
	public void ContactUsSendMessage() throws FileNotFoundException, IOException, ParseException
	{
		homeObject=new HomePage(driver);
		homeObject.openContactUsPage();
		JSONDataReader jsonContactUsReader = new JSONDataReader();
		jsonContactUsReader.jsonContactUsReader();
		
		contactUsObject=new ContactUsPage(driver);
		contactUsObject.ContactUs(jsonContactUsReader.name, jsonContactUsReader.email, jsonContactUsReader.enquiry);
		Assert.assertTrue(contactUsObject.contactUsConfirming.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
	}

}
