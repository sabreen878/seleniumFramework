package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{

	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	
	@Test
	public void UserCanSearchProduct() throws FileNotFoundException, IOException, ParseException
	{
		
		JSONDataReader jsonSearchReader = new JSONDataReader();
		jsonSearchReader.jsonSearchReader();
		
		searchObject=new SearchPage(driver);
		searchObject.productsearch(jsonSearchReader.productname);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.OpenProductDetailsPge();
		Assert.assertTrue(detailsObject.productsearchName.getText().contains("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(detailsObject.productsearchName.getText().equalsIgnoreCase(jsonSearchReader.productname));

	}
}
