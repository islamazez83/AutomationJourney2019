package AutomationJourney2019.WEBSites.Udemy.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class JSONDataReader {
  
  @DataProvider
  public Object[][] dp() {
	  Object[][] Data = new Object[3][2];
	  String FilePath = System.getProperty("user.dir")+"/WEBSites/src/test/java/AutomationJourney2019/WEBSites/Udemy/Data/UdemyUserAccountsData.json";
	  File srcFile = new File(FilePath);
	  JSONParser parser = new JSONParser();
	  try {
		JSONArray JArray = (JSONArray) parser.parse(new FileReader(srcFile));
		for(Object jsonObj : JArray) 
		{
			JSONObject person = (JSONObject) jsonObj;
			if(person.get("IsUsed") == "No") 
			{
				Data[0][0] = "Full name";
				Data[0][1] = person.get("Full name");
				Data[1][0] = "Email";
				Data[1][1] = person.get("Email");
				Data[2][0] = "Password";
				Data[2][1] = person.get("Password");
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
