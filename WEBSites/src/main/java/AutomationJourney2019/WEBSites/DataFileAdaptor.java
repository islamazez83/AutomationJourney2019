package AutomationJourney2019.WEBSites;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import AutomationJourney2019.User;
import AutomationJourney2019.Users;

import org.json.JSONWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataFileAdaptor {
	public List<User> ReadJSONData (String FullFileName) throws FileNotFoundException, IOException, ParseException 
	{
		String FilePath = System.getProperty("user.dir") + "/Data/" + FullFileName;
		File SrcFile = new File(FilePath);
		JSONParser parser = new JSONParser();
		List<User> UsersArray = (List<User>) parser.parse(new FileReader(SrcFile));
		return UsersArray;
	}
	public void UpdateJSONValue(String FullFileName, String UserFullName ,String KeyName, String UpdatedValue) throws JsonParseException, JsonMappingException, IOException, ParseException 
	{
		String FilePath = System.getProperty("user.dir") + "\\Data\\" + FullFileName;
		ObjectMapper mapper = new ObjectMapper();	
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Users[] u = mapper.readValue(new File(FilePath), Users[].class);
		for (Users itr : u) {
			JSONArray user = itr.getUser(UserFullName);
			JSONObject modifiedUser = (JSONObject) user.get(0);
			modifiedUser.put(KeyName, UpdatedValue);
			
			//user.remove(0);
			//user.add(modifiedUser);
			//itr.setUser(user);
			
			//mapper.writeValue(new File(FilePath), UpdatedValue);
			break;

		}
		//String oldValue = u.getUser().get(3).toString();
		//if (!UpdatedValue.equals(oldValue)) {
		//	u.setUser(user);put(KeyName, UpdatedValue);
		//}
		/*try (FileWriter file = new FileWriter(FilePath)) {
			//file.write(root.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
}
