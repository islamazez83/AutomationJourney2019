package AutomationJourney2019.WEBSites.Udemy.POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import AutomationJourney2019.WEBSites.Pages.PageBase;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[4]/div[6]/div/button")
	private WebElement SignUpButton;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[4]/div[5]/div/button")
	private WebElement LoginButton;
	
	@FindBy(name = "fullname")
	private WebElement FullNameTextBox;
	
	@FindBy(name = "email")
	private WebElement EmailTextBox;
	
	@FindBy(name = "password")
	private WebElement PasswordTextBox;
	
	@FindBy(xpath = "/html/body/div[8]/div[2]/div/div/div/div/div/div/div/div/div[3]/div[2]/span/div/a")
	private WebElement SignUpWithEmailButton; 
	
	@FindBy(id = "submit-id-submit")
	private WebElement PopUpSignUpButton;
	
	@FindBy(className = "user-avatar user-avatar--initials")
	public WebElement UserAvatar;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[4]/div[8]/span/div/ul/li[13]/a")
	private WebElement LogOutAnchor;
	
	@FindBy(className = "with-icon alert alert-success")
	public WebElement LoggedOutLabel;
	
	@FindBy(className = "alert alert-danger js-error-alert")
	public WebElement SignUpErrorLabel;
	
	public void SignUpNewUser(String FullName, String Email, String Password) 
	{
		clickButton(SignUpButton);
		if (isElementPresent("xpath", "/html/body/div[8]/div[2]/div/div/div/div/div/div/div/div/div[3]/div[2]/span/div/a")) {
			SignUpWithEmailButton.click();
		}
		waitForElementToBe("elementToBeClickable", FullNameTextBox);
		setTextElementText(FullNameTextBox, FullName);
		setTextElementText(EmailTextBox, Email);
		setTextElementText(PasswordTextBox, Password);
		clickButton(PopUpSignUpButton);		
	}
	
	public boolean isElementBresen(String by, String LocatorValue) 
	{
		return isElementPresent(by, LocatorValue);
	}
	
	public void LogOut() {
		action.moveToElement(UserAvatar).moveToElement(LogOutAnchor).click().build().perform();
	}
}
