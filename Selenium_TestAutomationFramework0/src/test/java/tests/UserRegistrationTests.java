package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.userRegisterPage;

public class UserRegistrationTests extends TestBase{
	

	HomePage homeObject;
	userRegisterPage registerObject;
	LoginPage loginObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new userRegisterPage(driver);
		registerObject.userRegistration("sabreen", "khaled", "test12@test.com", "123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogOut()
	{
		registerObject.UserLogOut();
	}
	
	
	@Test(dependsOnMethods = {"RegisteredUserCanLogOut"})
	public void RegisteredUseCanLogin()
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin("test12@test.com", "123456789");
		
		Assert.assertTrue(registerObject.logOutLink.isDisplayed());
	}
	

}
