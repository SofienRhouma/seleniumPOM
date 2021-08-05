package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountPT extends TestBase2
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "12345678";
	String newPassword = "123456";
	String firstName ="Sofien";
	String lastName = "Rhouma";
	String email = "mouhamed.chinkou112543@outlook.fr";

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully()
	{
		homeObject = new HomePage(getDrivre());
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(getDrivre());
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(getDrivre());
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
		myAccountObject.customerInfoLink();
		

	}
	@Test(dependsOnMethods = {"RegisteredUserCanChangePassword"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}

	@Test(dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(getDrivre());
		loginObject.UserLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}


}
