# Recruitment Task
Solution of the recruitment task for one of the companies for the position of junior java developer.

## Task:
Your task is to write a program that will allow you to sort files. The program should create a directory structure

- HOME
- DEV
- TEST

When a file appears in the HOME directory, depending on the extension, it will move it to the folder according to the following rules

- move the file with the .jar extension, whose creation time is even, to the DEV folder
- move the file with the .jar extension, the creation time of which is odd, to the TEST folder
- file with .xml extension, move to the DEV folder

Additionally, in the newly created file /home/count.txt, the number of transferred files (all files and divided into directories) should be stored, the file should store the current number of processed files at any time during the program operation.
