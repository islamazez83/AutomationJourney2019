package AutomationJourney2019.WEBSites.Udemy;

import org.testng.annotations.Test;

import AutomationJourney2019.WEBSites.Tests.TestBase;
import AutomationJourney2019.WEBSites.Udemy.POMs.HomePage;

public class SignUpNewUserTestClass extends TestBase {
	
	@Test
  public void UdemySignUpNewUser() {
		HomePage HomePageObject = new HomePage(getDriver());
		getDriver().navigate().to(getWebSitesURL()[0].toString());
		HomePageObject.SignUpNewUser();
  }
}
