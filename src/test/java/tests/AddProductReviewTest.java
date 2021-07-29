package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase
{
	
	/*
	 * 1 - User registration
	 * 2 - Search for product
	 * 3 - Add review
	 * 4 - Logout
	 * 
	 */

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;
	
	//1 - User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Sofien", "Rhouma", "mouamedd85@outlook.fr", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	// 2- Search For Product
	@Test (priority = 2)
	public void UserCanSearchWithAutoSuggest() 
	{
		searchObject =new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		
	}
	
	
	// 3- Add review 
	@Test(priority = 3)
	public void RegistereUserCanReviewProduct() 
	{
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("new review ", "the product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText()
				.contains("Product review is successfully added."));
		
	}
	
	// 4- User logout 
	@Test(priority = 4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
}
