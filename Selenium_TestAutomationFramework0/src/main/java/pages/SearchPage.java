package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchBTN;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productList;	
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	
	public void productsearch(String productName) {
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBTN);
	}
	
	public void OpenProductDetailsPge() {
		
		clickButton(productTitle);
	}
	
	
	public void ProductSearchUsingAutoSuggest(String searchTxt) throws InterruptedException
	{
		setTextElementText(searchTxtBox, searchTxt);
		Thread.sleep(3000);
		productList.get(0).click();
	}

}
