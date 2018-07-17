#Solution


The main flow of the application is located under analist service. In general, the algorithm is divided in 4 steps. 
The first one, the app reads from a text file a list of entries from the museum and creates a list. This is done in the Reader service.
The second one, it is about update each entry what is the number of visitors for that specific entry.
The third one, the system analyzes the ranges with the maximum number of visitors and find the proper ranges of start time and end time.
Finally, system prints the ranges which can be several.


#Note
In this exercise you can find 3 cases that are tested in the test folder.

a) For the given entries, there is only one period with max number of visitors
b) For the given entries, there are several entries with the same max number of visitors but the dates intersect each other
b) For the given entries, there are several entries with the same max number of visitors but the dates do not intersect each other