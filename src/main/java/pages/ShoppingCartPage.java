package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button.remove-btn")
	WebElement removeCheck;
	
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;
	
	@FindBy(id = "itemquantity11219")
	public WebElement quantityTxt;
	
	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement agreeCheckbox;
	
	public void RemoveProductFromCart() 
	{
		clickButton(removeCheck);
		//clickButton(updateCartBtn);
		
	}
	
	public void UpdateProductQuantityInCart(String quantity) throws InterruptedException 
	{
		//clear quantity textboxs
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	
	public void openCheckoutPage() 
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}

}
