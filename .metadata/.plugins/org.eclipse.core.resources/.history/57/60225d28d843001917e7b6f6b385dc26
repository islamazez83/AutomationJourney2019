package AutomationJourney2019.WEBSites.Udemy.POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import AutomationJourney2019.WEBSites.Pages.PageBase;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[4]/div[6]/div/button")
	private WebElement SignUpButton;
	
	@FindBy(linkText = "Log In")
	private WebElement LoginButton;
	
	public void SignUpNewUser() 
	{
		clickButton(LoginButton);
	}

}
