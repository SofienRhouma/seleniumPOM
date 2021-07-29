package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCheckoutProductFromCart extends TestBase
{
	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void UserCanSearchWithAutoSuggest() 
	{
		searchObject =new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new ProductDetailsPage(driver);
		Assert.assertEquals(productDetails.productNamebreadCrumb.getText(), productName);
		
	}
	@Test(priority = 2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException 
	{
		cartObject = new ShoppingCartPage(driver);
		productDetails.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.totalLbl.getText().contains("$3,600.00"));
	}
	
	@Test(priority = 3)
	public void UserCanCheckoutProduct() throws InterruptedException 
	{
		checkoutObject = new CheckoutPage(driver);
		cartObject.openCheckoutPage();
		checkoutObject.openCheckoutPageGuest();
		checkoutObject.CheckoutProduct("test", "user","Egypt", "testuser8@test.com", "test addres", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
	}
	
	@Test(priority = 4)
	public void UserCanViewOrderDetails() throws InterruptedException 
	{
		orderObject = new OrderDetailsPage(driver);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderObject.PrintOrderDetails();
	}

}
