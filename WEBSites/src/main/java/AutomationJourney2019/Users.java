package AutomationJourney2019;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import AutomationJourney2019.WEBSites.DataFileAdaptor;

public class Users {

	private JSONArray user =  new JSONArray();

	public JSONArray getUser(String FullUserName) throws FileNotFoundException, IOException, ParseException {
		DataFileAdaptor DFA = new DataFileAdaptor();
		JSONArray usersArray = (JSONArray) DFA.ReadJSONData("Udemy/UdemyUserAccountsData.json");	

		for (Object jsonObj : usersArray) {	
			int i = 0;
			JSONObject person = (JSONObject) jsonObj;
			if (person.get("FullName").toString().equals(FullUserName)) {
				user.add(usersArray.get(i));				
				break;
			}
			i++;
		}
		return user;
	}

	public void setUser(JSONArray user) {
		this.user = user;
	}
}