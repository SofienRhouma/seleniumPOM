package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFrindTest extends TestBase
{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	
	//1 - User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Sofien", "Rhouma", "mouhamed.derb@outlook.fr", "12345678");
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
	
	
	// 3- Email to Friend
	@Test(priority = 3)
	public void RegistereUserCanSendProductToFriend() 
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFrind("abc@test.com", "Hello mac");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message"));
	}
	
	// 4- User logout 
	@Test(priority = 4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	

}
