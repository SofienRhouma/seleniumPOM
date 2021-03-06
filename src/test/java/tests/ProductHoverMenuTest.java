package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage homeObject;
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.selectNotebooksMenu();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
