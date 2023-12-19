# JSONFileArchiveProject

Write a Java Program that will read a JSON file for program variables and move files from one folder to another which are over x-number of days old.

The program should iterate through the files in the "Files" folder and for file older than the variable "days_old" should move the files to the "destinationfolder" location. You should be able to change the variable "days_old" and alter the files which get moved/archived. 

You will need to access system resources for folders and directories to perform this task.  ONLY Archive files, do not move any subfolders.

The JSON file will specify 3 variables:  "sourcefolder",  "destinationfolder", and  "days_old"
