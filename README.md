## Assignment 3 client side for Introduction to Service Design and Engineering -course of UNITN

### General info of the assignment
In the assignment I worked alone.   
The server for my assignment is running in [http://introsde-assignment3.herokuapp.com/ws/people?wsdl](http://introsde-assignment3.herokuapp.com/ws/people?wsdl)  
The server repository can be found from: [https://github.com/tooga/introsde-2015-assignment-3-server] (https://github.com/tooga/introsde-2015-assignment-3-server)

### How to run the program?
The program uses ant build-tool for running the program. To execute the program, please open the terminal and run the following command in the root directory of the program:

	ant execute.client

The command installs all dependencies and executes the client. The client sends requests to the remote server running on Heroku and prints the results to the terminal and also saves them to a log file in the root folder.	
