# Task

A museum recorded the entering and leaving time for each visitor during the day with one minute precision. This resulted in N pairs, where the first value indicates the start and the second the end time of the visit. Find the time period when there were the most number of visitors in the museum and how many were there. The start and end of the visit time are both inclusive. For example, if one visitor arrived at 11:10 and the other left at 11:10, it is considered that at 11:10 there were 2 visitors in the museum.

# Desired Solution
 
1. Implement a program that:
  - Reads visits in the input file. The location of the input file is provided to the program as a command line parameter. The file is a text file where each line corresponds to one visitor, visit start and end time separated by comma. For example,
  ```
  10:15,14:20
  11:10,15:22
  ```
  The visiting times can be in the file in any order. For testing, you can make use of the sample file provided `visiting-times.txt`
  - Based on the data in the input file, finds the time period when there were the most visitors in the museum and how many of them were there. 
  - Prints that time period and number of visitors in the standard output in the following form: `<start time> - <time period end>; <number of visitors>`. For example: `11:10 - 14:20; 2`
2. Place all source code in sub directory `src`.
3. Describe the algorithm for finding the time period and number of visitors in Markdown file `Finding the time period.md`.
4. Document the source code for public classes and methods according to javadoc rules and generate a javadoc utility documentation in a separate `javadoc`directory.



# How to run the program
Remember that the program runs only with absolute paths


Execute in windows
`java -jar museum-1.0.jar C:\Users\(User_Name)\Documents\visiting-times.txt`

Execute in Linux
`java -jar museum-1.0.jar /home/(user_name)/visiting-times.txt`