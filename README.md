# DS Project

# Table of Contents
* [Description](#description)
* [Getting Started](#getting-started)
* [Examples](#examples)
* [Extras](#extras)
* [Built With](#built-with)
* [License](#license)

## Description
This project contain a Rest server which hosts json data taken from an RMI service that interacts with an SQL database. TThe project also contains a web client which retrieves its data from the rest API and displays that to the user.

### Rest-Server
The rest server is responsible for allowing the web client access to the database. It does this by using the RMI server to call function to interact with the database. It gets this data as an object. The object is no use to display on the website, which is why I used [GSON](https://en.wikipedia.org/wiki/Gson). [GSON](https://en.wikipedia.org/wiki/Gson) allowed me to 'unpack' the object easily into JSON data to be displayed to the browser.

The rest server is responsible for database related querying. If a user wishes to edit, delete, add or view and material in the database they must go through the rest api.

### RMI-Server
The RMI server is a database service which allows the Rest-Server to use its functions by adding them to the RMI registry. The RMI server just sits and waits until the rest server calls one of it's method where it runs the operation before waiting again for the next operation.

### Web-Client
The web client is repsonible for all user interaction and displaying the UI of the project. The web client makes  GET, POST, PU and DELETE requests to the Rest-Server which handles those queries and either sends back the relevant information or executes a given instruction with the data given to it.

## Getting Started
First thing to do is clone the project. To do that create a folder to contain the project and enter this command:
```
> git clone https://github.com/badwulf51/DSProject2019
```
### Running Project
Running this project is a bit different to other as it is three seperate eclipse project which all interact with one another in some way.

To run simply:

1. Run the 'RMI-Server' by right clicking 'RMISetup.java' in the 'ie.gmit.sw' package and running it as a 'Java Application'
2. Run the 'Rest-Server' by right clicking the project and running it as a Tomcat 8.5 server which is also included in this project
3. Run the 'Web-Client' by right clicking the project and running it as a Tomcat 8.5 server. (Same step as the Rest-Server)

## Examples
### Adding Data Example:
[![Adding Data](https://imgur.com/WB79WMk.png)](https://youtu.be/BiQYRsMpJWI)

### Deleting Data Example:
[![Deleting Data](https://imgur.com/gc2v3fj.png)](https://youtu.be/exTfFLUWLEQ)

## Extras
1. GSON
I used [GSON](https://en.wikipedia.org/wiki/Gson): to serialize and deserialize Java objects to JSON. This allowed the RMI to send an object which can then be 'unpacked' into JSOn data to be displayed on the rest server api.

2. [CSS Styling](https://github.com/cian2009/DSProject/blob/master/Client/WebContent/style.css)
I created a custom css file with custom styling for the project to give user input a bit of flavor.

3. Smart querying: Removing customer will also remove their bookings. Removing a car will also remove a booking as the car will no longer be available.

## Built With

* [Eclipse](https://www.eclipse.org/) - IDE used scripts
* [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Programming laguage used
* [Tomcat 8.5](https://tomcat.apache.org/download-80.cgi) - Tomcat was used to host the Rest-Server and Web-Client projects
* [GSON](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/) - GSON was used to serialize and deserialize Java objects to JSON.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details
