package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userRegisterPage extends PageBase {

	public userRegisterPage(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(id = "gender-female")
	WebElement genderRadioBTN;

	@FindBy(id = "FirstName")
	WebElement FirstNameTextBox;

	@FindBy(id = "LastName")
	WebElement LastNameTextBox;

	@FindBy(id = "Email")
	WebElement EmailTextBox;

	@FindBy(id = "Password")
	WebElement PasswordTextBox;

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordTextBox;

	@FindBy(id = "register-button")
	WebElement registerBTN;

	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logOutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	public void userRegistration(String firstName, String lastName, String email, String password)
	{		
		clickButton(genderRadioBTN);
		setTextElementText(FirstNameTextBox, firstName);
		setTextElementText(LastNameTextBox, lastName);
		setTextElementText(EmailTextBox, email);
		setTextElementText(PasswordTextBox, password);
		setTextElementText(ConfirmPasswordTextBox, password);
		clickButton(registerBTN);
	}
	
	public void UserLogOut()
	{
		clickButton(logOutLink);
	}
	
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}

}
