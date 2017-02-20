Meetings Timetable Problem
==========================

This code will try to solve the meeting schedule problem. The description of the problem is
"In a company, multiple teams share one conference room. Teams have meetings but you are having trouble fitting them into the working time of the day."

The current code will iterate the meetings informed trying to fit them in the morning period (9-12) and if doesn't fit tries to add to the afternoon period (13-17:45), and add a day meeting after.

The code is divided in three parts:

- A reader implementation, it read from a txt file. Each line of the file correspond to a meeting, the meeting is defined with name and a duration separated by "-".
- A scheduler implementation, it receives a list of meetings and encapsulate those in a new object called ScheduleMeeting if it can be added to the schedule. 
- A writer implementation, it writes the scheduled meeting to an ouput file.

Each implementation, implements an interface with the idea that the class MeetingProcessor could receive different parameters based on the program arguments, and decide which implementation to use. So it would be easier to create a json, xml, or whatever implementations for reading, writing or even scheduling.  

The scheduler just try to fit the meeting while iterating the elements, but since it's a timetable problem a greedy (with a stop criteria) or genetic algorithm would find a more optimal solution. 

To run the program, you just call  "java -jar /path/to/jar "/path/to/input/file"", the output file will be saved to same folder where the input file is, and the name will be "output.txt".
