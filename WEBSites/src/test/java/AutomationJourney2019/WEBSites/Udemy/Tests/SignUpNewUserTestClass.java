package AutomationJourney2019.WEBSites.Udemy.Tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import AutomationJourney2019.WEBSites.Tests.TestBase;
import AutomationJourney2019.WEBSites.Udemy.Data.JSONDataReader;
import AutomationJourney2019.WEBSites.Udemy.POMs.HomePage;

public class SignUpNewUserTestClass extends TestBase {
	
	HomePage HomePageObject;
	
	@Test(dataProvider = "SignupUsersDP", dataProviderClass = JSONDataReader.class)
  public void UdemySignUpNewUser(String FullName, String Email, String Password) throws InterruptedException {
		getDriver().manage().deleteAllCookies();
		HomePageObject = new HomePage(getDriver());
		getDriver().navigate().to(getWebSitesURL()[0].toString());
		Thread.sleep(6000);
		
		// Handle CAPTCHA
		//String mainWindow =  getDriver().getWindowHandle();
		//getDriver().findElements(By.tagName("iframe")).get(0);
		//getDriver().switchTo().window(mainWindow);
		//Thread.sleep(3000);
		//getDriver().findElements(By.tagName("iframe")).get(1);
		HomePageObject.SignUpNewUser(FullName, Email, Password);
		assertTrue(HomePageObject.UserAvatar.isDisplayed());
		HomePageObject.LogOut();
		assertTrue(HomePageObject.LoggedOutLabel.isDisplayed());
  }
}
