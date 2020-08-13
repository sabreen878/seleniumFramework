package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.userRegisterPage;

public class UserRegistrationTestsWithDDTAndJsonFile extends TestBase{

	HomePage homeObject;
	userRegisterPage registerObject;
	LoginPage loginObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws IOException, ParseException
	{
		
		JSONDataReader jsonReader = new JSONDataReader();
		jsonReader.jsonReader();
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new userRegisterPage(driver);
		registerObject.userRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogOut()
	{
		registerObject.UserLogOut();
	}
	
	
	@Test(dependsOnMethods = {"RegisteredUserCanLogOut"})
	public void RegisteredUseCanLogin() throws IOException, ParseException
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		
		JSONDataReader jsonReader = new JSONDataReader();
		jsonReader.jsonReader();
		
		loginObject.UserLogin(jsonReader.email, jsonReader.password);
		
		Assert.assertTrue(registerObject.logOutLink.isDisplayed());
	}
	

}
