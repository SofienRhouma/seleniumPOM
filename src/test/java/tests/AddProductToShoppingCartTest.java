package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartPage;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException
	{
		searchPage = new SearchPage(driver);
		searchPage.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException 
	{
		productDetails = new ProductDetailsPage(driver);
		productDetails.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("$3,600.00"));
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() throws InterruptedException 
	{
		cartPage = new ShoppingCartPage(driver);
		Thread.sleep(1000);
		cartPage.RemoveProductFromCart();
		
	}

}
