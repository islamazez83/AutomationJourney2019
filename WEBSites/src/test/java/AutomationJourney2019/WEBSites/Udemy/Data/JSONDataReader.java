package AutomationJourney2019.WEBSites.Udemy.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import AutomationJourney2019.User;
import AutomationJourney2019.WEBSites.DataFileAdaptor;


public class JSONDataReader {
  
  @DataProvider
  public Object[][] SignupUsersDP() {
	  Object[][] Data = new Object[2][3];
	  int usersCount = 0;
	  try {
		  DataFileAdaptor DFA = new DataFileAdaptor();
		List<User> SignupUsers = DFA.ReadJSONData("Udemy/UdemyUserAccountsData.json");		
		
		for(Object jsonObj : SignupUsers) 
		{
			JSONObject person = (JSONObject) jsonObj;
			if(person.get("IsUsed").toString().equals("No")) 
			{
				Data[usersCount][0] = person.get("FullName");
				Data[usersCount][1] = person.get("Email");
				Data[usersCount][2] = person.get("Password");
				usersCount++;
				if (usersCount == Data.length) {
					break;
				}
			}
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return Data;
  }
}
