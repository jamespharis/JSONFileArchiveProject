package jsonFileArchive;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrimaryCode {
	
	public static void main(String[] args) {
		GetJSONarguments configObject = new GetJSONarguments(); //create configObject that will call GetJSONarguments
		//Get variables from GetJSONarguments using configObject
		String source = configObject.getSource();
		String dest = configObject.getDest();
		long days_old = configObject.getDays_Old();
		
		//Create File variables for source & dest in order to read attributes from java.io.File
		File myStart = new File(source);
		File myDest = new File(dest);
		if((myStart.exists()) && (myDest.exists())) { System.out.println("Source & Destination exist.");
			if((myStart.isDirectory()) && (myDest.isDirectory())){ System.out.println("Source & Destination are directories.");
			 //DATE CALCULATION:	
			LocalDateTime localDateTime = LocalDateTime.now(); // Find current date
	        localDateTime = localDateTime.minusDays(days_old); // Subtract days_old from current date
	        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault()); //initializing variable zdt
	        long diff = zdt.toInstant().toEpochMilli(); //conversion to long format
	        
	         //ITERATION
	        File[] files = new File(source).listFiles(); // Initialize files
	        int i = 1;
	        for(File currentFile : files) { 
	        	if(currentFile.exists()) {System.out.print(currentFile);} //Check if exists & print file name
	        	else {System.out.println("- - - ERROR: NONEXISTENT FILE - - -");} //error if nonexistent
	        	if ((currentFile.lastModified() < diff) && (currentFile.isDirectory() == false)){
	        		System.out.println(" - - - Will Be Moved");
	        		//DECLARING & MOVING
	        		String CfileName = currentFile.getName(); //creating a new String from the CurrentFile
	        		Path srcFile = Paths.get(source+"\\"+CfileName); // creating a starting Path for our new String
	        		Path destFile = Paths.get(dest+"\\"+CfileName); // creating a destination Path for our new String 
	        		
	        		try { Files.move(srcFile, destFile); } //attempting to move current file
	        		catch(IOException e) {e.printStackTrace(); }
	        		
	        		i = i + 1; //iteration
	        	}else {System.out.println(" - - - Does Not Meet Criteria & Will Stay");}
	        }
			
			}else {System.out.println("Either Source or Destination is not a directory");}
		}else {System.out.println("Either Source or Destination does not exist");}
	}		
}
