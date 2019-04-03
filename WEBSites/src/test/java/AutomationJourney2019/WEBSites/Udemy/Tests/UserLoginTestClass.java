package AutomationJourney2019.WEBSites.Udemy.Tests;

import org.testng.annotations.Test;

import AutomationJourney2019.WEBSites.Tests.TestBase;
import AutomationJourney2019.WEBSites.Udemy.POMs.HomePage;

public class UserLoginTestClass extends TestBase {
	HomePage HomePageObject ;
  @Test
  public void UdemyLogIn() {
	  getDriver().manage().deleteAllCookies();
	  HomePageObject = new HomePage(getDriver());
	  getDriver().navigate().to(getWebSitesURL()[0].toString());
	  //HomePageObject.UserLogIn();
  }
}
