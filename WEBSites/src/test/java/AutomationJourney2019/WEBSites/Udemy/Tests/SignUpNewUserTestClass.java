package AutomationJourney2019.WEBSites.Udemy.Tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import AutomationJourney2019.WEBSites.DataFileAdaptor;
import AutomationJourney2019.WEBSites.Tests.TestBase;
import AutomationJourney2019.WEBSites.Udemy.Data.JSONDataReader;
import AutomationJourney2019.WEBSites.Udemy.POMs.HomePage;

public class SignUpNewUserTestClass extends TestBase {
	
	HomePage HomePageObject;
	
	@Test(dataProvider = "SignupUsersDP", dataProviderClass = JSONDataReader.class)
  public void UdemySignUpNewUser(String FullName, String Email, String Password) throws InterruptedException, JsonParseException, JsonMappingException, IOException, ParseException {
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
		assertFalse(HomePageObject.isElementPresent("className", "alert alert-danger js-error-alert"));
		DataFileAdaptor DFA = new DataFileAdaptor();
		DFA.UpdateJSONValue("Udemy\\UdemyUserAccountsData.json", FullName,"IsUsed", "Yes");
		HomePageObject.LogOut();
		assertTrue(HomePageObject.LoggedOutLabel.isDisplayed());
  }
}
