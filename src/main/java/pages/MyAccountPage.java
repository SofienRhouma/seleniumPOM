package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;

	@FindBy(id="OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;

	@FindBy(css="button.button-1.change-password-button")
	WebElement ChangePasswordBtn;

	@FindBy(css ="p.content")
	public WebElement resultLbl; 

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[1]/a")
	WebElement customerInfo;
	
	@FindBy(id = "save-info-button")
	WebElement saveBtn;



	public void openChangePasswordPage() 
	{
		clickButton(changePasswordLink);
	}

	public void ChangePassword(String oldpassword, String newpassword) 
	{
		setTextElementText(oldPasswordTxt, oldpassword);
		setTextElementText(newPasswordTxt, newpassword);
		setTextElementText(confirmPasswordTxt, newpassword);
		clickButton(ChangePasswordBtn);
	}
	public void customerInfoLink() 
	{
		clickButton(customerInfo);
		clickButton(saveBtn);
	}

}
