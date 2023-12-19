# JSONFileArchiveProject

Write a Java Program that will read a JSON file for program variables and move files from one folder to another which are over x-number of days old.

The program should iterate through the files in the "Files" folder and for file older than the variable "days_old" should move the files to the "destinationfolder" location. You should be able to change the variable "days_old" and alter the files which get moved/archived. 

You will need to access system resources for folders and directories to perform this task.  ONLY Archive files, do not move any subfolders.

The JSON file will specify 3 variables:  "sourcefolder",  "destinationfolder", and  "days_old"

#Steps:
 *  Retrieve values from JSON
 *  Validate that source & destination are valid directories
 *  Days_old Date Calculation
 *  Iterate through source directory [LOOP]
 *  For each object in the source directory, Declare path as file object (allows us to run properties on each file)
 *  Verify that it is a file (not directory)
 *  Evaluate file properties for date/time (last modified date)
 *  If qualifies, move file. If not, go to next file.
