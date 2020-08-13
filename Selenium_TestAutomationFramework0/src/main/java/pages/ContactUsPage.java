package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id = "FullName")
	WebElement contactUsFullName;
	
	@FindBy(id = "Email")
	WebElement contactUsEmail;
	
	@FindBy(id = "Enquiry")
	WebElement contactUsEnquiry;
	
	@FindBy(name = "send-email")
	WebElement contactUsSendBTN;
	
	@FindBy(css = "div.result")
	public WebElement contactUsConfirming;
	
	
	public void ContactUs(String fullName, String email, String enquiry) 
	{
		clickButton(contactUsLink);
		setTextElementText(contactUsFullName, fullName);
		setTextElementText(contactUsEmail, email);
		setTextElementText(contactUsEnquiry, enquiry);
		clickButton(contactUsSendBTN);
	}
}
