# SpringSort

Get Sorted!!!

About Program -
This is a web application which lets user to enter comma separated integer values, and display
the sort results with following attributes.

1) Numbers -- Original set of numbers
2) Sorted Numbers -- Sorted Numbers in ascending order
3) Number of Changes -- Swaps made to achieve sorted results
4) Time taken -- Time taken in nano seconds, to achieve sorted results 

Technology Used --

Java - jdk1.7.0_17
jstl-1.2 -- for clientside scripting
jsp1.2 -- for client side scripting
spring 4.3.6 -- for framework
gson-2.8.0 --for serealization 
Tomcat 6.0 -- webserver
HTML -- client side

This is a Spring MVC application.

Deployment--

Server Apache Tomcat v 6.0.53

download GetSorted.war from Github
upload .war file to webapps folder/directory in Tomcat server

start server from command shell--
./apache-tomcat-6.0.53/bin/startup.bat

open the browser at http://localhost:8080/GetSorted/NumberList

Assuming your server started with no errors, you would be looking at screen, where 
you can add your numbers, and sort them.

NOTE: Add you numbers in comma separated format 
e.g. 8,44,555,32,55,66,1



