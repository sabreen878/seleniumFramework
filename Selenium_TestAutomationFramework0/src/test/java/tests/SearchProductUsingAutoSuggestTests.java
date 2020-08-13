package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTests extends TestBase{
	

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void UserCanSearchWithAutoSuggest() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("mackb");
		detailsObject=new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productsearchName.getText().contains("Apple MacBook Pro 13-inch"));
	}

}
