
Demo Webshop with Spring Boot + Theamleaf / Bootstrap 
============================================================

To start the build over maven 
-> go to directory 
and type:

	mvn spring-boot:run

You can use Netbeans IDE to compile your own webshop from
https://netbeans.apache.org/
from here you can start as jar.


If you use Jetbrains IDE you can set up the path 
under settings -> Tools -> Settings Repository and
add 
--> http://repo.maven.apache.org/maven2/ 
and updated with invalidated and restart.



an run the applcation with maven repository over
terminal.
You can install maven from here:
https://maven.apache.org/download.cgi





the programm is testet under java java-1.8.0-openjdk-i386
and maven repository from 
http://repo.maven.apache.org/maven2/


make sure that h2 demodatabases are installed.
https://github.com/demogitjava/demodatabase.git

The default path is your users directory as root
under ubuntu is
<br/>
/root
<br/>
for an other path you have to edit the application.properties file

<br/>

DemoFolder Images 
resources/static/images/imgproducts

png File w 400 h 250
for NAS Storage or Cluster with docker you 
have to edit the  path in 

Database Table PRODCUTS
-> column // IMAGE

in index.html search "imagecardproduct" if you
would like to edit File size w 400 h 250

<br/>


the languages over the h2 database are supported

-de
-en
-es
-fr
-it
-tk

<br/>





