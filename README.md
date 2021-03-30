# flightsearchapplication


Implement a standalone flight search program in Java, using Hibernate that lists matching flights for a traveller who is looking to fly between 2 locations on a given date. The input locations should be 3 letter location code format as present in airlines flight data.

You are given 3 CSV files, each containing the available flight data for Air India, Jet Air, IndiGo respectively. Sample CSV files links are attached here for reference. You can add more data in existing files or can add more CSV files for another airlines. The data from these files needs to be persisted in the database. All the search operations for the flights will be done on the database using hibernate.
Air India Data 
Jet Air Data
Indigo Data

Program should accept 5 input parameters
Departure Location
Arrival Location
Flight Date
Flight Class
Output Preference 

“Flight Class” is a String which has two possible values like ‘E’ and ‘B’. E=Economic and B=Business.
“Output Preference” is a String which suggests whether flight result should be sorted only by fare or by both  fare and flight duration.


After getting the inputs, program should search for the flights in the database and list the results on standard output, sorted by Fare and Flight Duration
Program should be written considering that there could be more csv files and at runtime program should load the files. Please make use of Thread which will look for any new file at particular location after some configurable time and load the provided file
If no matching flight is found for the given input, user friendly output should be displayed on the screen.
Maven 3.x should be used
Use the new features of Java 8 wherever possible
Output
Program should display the list of available flights with details on console  for provided user inputs and if user enters “Flight Class” as ‘B’ then fare should be increased by 40% of the base fare.(CSV file has the base fare only)

