# JSONFileArchiveProject

This Java program will read a JSON file for program variables and move files from one folder to another if they are over x-number of days old.

The program iterates through the files in the "sourcefolder" and moves files older than the variable "days_old" to the "destinationfolder" location.
Changing the variable "days_old" will alter which files get moved/archived. 

This program accesses system resources for folders and directories to perform this task. ONLY files are moved, not subfolders.

The JSON file will specify 3 variables:  "sourcefolder",  "destinationfolder", and  "days_old"

Steps Taken:
 *  Retrieve values from JSON
 *  Validate that source & destination are valid directories
 *  Days_old Date Calculation
 *  Iterate through source directory
 *  For each object in the source directory, Declare path as file object & verify that it is a file (not directory)
 *  Evaluate file properties for date/time (last modified date)
 *  If qualifies, move file. If not, go to next file.
