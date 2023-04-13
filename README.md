# Call-Center

We are creating a project to calculate analytics from the call data saved for a callcenter, which can connect to the database, process the data and print the output on the console.

This project is designed to demonstrate the use of Core Java programming language to build a call center application that can interact with a database.


The project uses the following technologies:

Core Java ||
JDBC ||
MySql Database

This project uses the following libraries:

» MySQL Connector/J - for JDBC driver to connect to MySQL database


The project has the following features:

» This project uses JDBC API to connect to the database and fetch the data. <br>

» It then processes the data using Java streams and prints the output on the console. <br>

» Database connection: The project connects to a database using MySql.

» Data processing: The project retrieves data from the database, processes it, and prints the output on the console.

» Console output: The project prints the processed data on the console.

Each call that is received by the callcenter is saved in a database table shown below:

![image](https://user-images.githubusercontent.com/69083112/231590004-f0e01200-4889-4b13-b36b-2488f2d382e1.png)

Sample data is given below:

![image](https://user-images.githubusercontent.com/69083112/231590444-5ada6e37-22cf-40d7-be62-967e1e6f0e17.png)

Table Structure is shown below:

![Table Structure](https://user-images.githubusercontent.com/69083112/231589230-0edf5e9e-22c4-4ea0-af9b-6c311787173f.png)

We have to create the following analytics:

1> Hour of the day when the call volume is highest.

2> Hour of the day when the calls are longest.

3> Day of the week when the call volume is highest.

4> Day of the week when the calls are longest.


Based on the provided data the output of the console is as follows:

![Console_Print](https://user-images.githubusercontent.com/69083112/231589448-56332ba5-be2e-466b-9a77-339a2aeb3c26.png)
![Console_Print2](https://user-images.githubusercontent.com/69083112/231585775-0e2c31a7-d76b-4cdf-9e3a-2ea85ef71b82.png)
![Console_Print3](https://user-images.githubusercontent.com/69083112/231585800-a76c709b-2750-4b5c-8f89-d622050fea8c.png)
![Console_Print4](https://user-images.githubusercontent.com/69083112/231585825-486a5a2f-8730-4b48-8527-544aaa5d8d1f.png)


To get started with the project, follow these instructions:

» Clone the project from GitHub repository. <br>

» Open the project in an IDE such as VS Code.

» Ensure that Java 8 or later is installed on your system.

» Set up the database connection in the project by modifying the application.properties file located in the mrinal_assignment/Dbconnect.java/ directory. 

» Update the dbcon, jdbc.username, and jdbc.password properties to match your database configuration.

» Run the project by executing the javac Dbconnect.java file.

Video Explanation for the project: https://drive.google.com/file/d/149Xbg-VcDyFU-IoRtPDzxgYAzkKwR1Gh/view

Thanks!



