package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div[2]/div/div/div/form/div[2]/div[1]/div[2]/div[1]")
	public WebElement productsearchName;

}
