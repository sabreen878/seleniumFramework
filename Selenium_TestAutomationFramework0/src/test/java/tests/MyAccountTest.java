package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.userRegisterPage;

public class MyAccountTest extends TestBase{
	
	HomePage homeObject;
	userRegisterPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccObject;
	String oldPassword="123456789";
	String newPassword="0000000000";
	String email="test20@test.com";
	String firstName="sabreen";
	String lastName = "khaled";
	
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new userRegisterPage(driver);
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UserRegisteredCanChangePassword()
	{
		myAccObject=new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccObject.changePasswordPage();
		myAccObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccObject.resultTxt.getText().contains("Password was changed"));
	}
	
	@Test(dependsOnMethods = {"UserRegisteredCanChangePassword"})
	public void RegisteredUserCanLogOut()
	{
		registerObject.UserLogOut();
	}
	
	
	@Test(dependsOnMethods = {"RegisteredUserCanLogOut"})
	public void RegisteredUseCanLogin()
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin("test12@test.com", newPassword);
		
		Assert.assertTrue(registerObject.logOutLink.isDisplayed());
	}
}
