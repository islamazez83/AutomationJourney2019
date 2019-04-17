package AutomationJourney2019.WEBSites;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataFileReader {
	public JSONArray ReadJSONData (String FullFileName) throws FileNotFoundException, IOException, ParseException 
	{
		String FilePath = System.getProperty("user.dir") + "/Data/" + FullFileName;
		File SrcFile = new File(FilePath);
		JSONParser parser = new JSONParser();
		JSONArray JArray = (JSONArray) parser.parse(new FileReader(SrcFile));
		return JArray;
	}

}
