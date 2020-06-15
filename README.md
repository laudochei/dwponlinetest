# dwptest
Department of Works and Pensions


Github Link for source code:
===========================
https://github.com/laudochei/dwptest



API URL to list all people
==========================
1. http://localhost:8090/people/peoplelist


API URL to list people either in London or within 50 miles of London
====================================================================
2. http://localhost:8090/people/city/London/50/users



Implementation:
==============
This program has been implemented in Java using Spring Boot framework
IDE- Apache NetbeansIDE 11.3


Algorithm to list people either in London or within 50 miles of London
======================================================================
1. Start
2. Get list of people living in London (List 1)
	-  get all people living in London into List 1
3. Get list of people living within 50 miles of London (List 2)
	- get input variables - latitude and longitude of London, distance limit, and unit of the distance
	- for each item in the list of people, calculate the distance between this location and London
	- if the distance is less than or equal to 50 miles, then all it to a list (List 2) 
4. Combine List 1 and List 2, and remove duplicates
5. Return list of people living either in London or within 50 miles of London
End.
 
