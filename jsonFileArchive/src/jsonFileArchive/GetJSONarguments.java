package jsonFileArchive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetJSONarguments {

	private String source;
	private String dest;
	private long days_old;
	@SuppressWarnings("unchecked")
	
	//Constructor
	public GetJSONarguments() 
	{
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("config.json"))
		{
            Object obj = jsonParser.parse(reader); // Read JSON file

            JSONObject configList = (JSONObject) obj;
            System.out.println(configList);
            
            //Retrieve values from config.json
            this.source = (String) configList.get("sourcefolder");
            this.dest = (String) configList.get("destinationfolder");
            this.days_old = (long) configList.get("days_old");
            System.out.println(getSource());
		}
		catch (FileNotFoundException e) { e.printStackTrace();} 
		catch (IOException e) { e.printStackTrace(); } 
		catch (ParseException e) { e.printStackTrace(); }
		}
	
	//Create getters to return current instances
	public String getSource() { return source; }
	public String getDest() { return dest; }
	public long getDays_Old() { return days_old; }		
}
