MULE can be either run in Mule -studio or run by deploying in standalone server


TO RUN MUle with integrating with TOMCAT
==========================================
Installing Mule on Tomcat
Download and install Apache Tomcat, following Apache’s installation instructions.
In the Tomcat home directory on your system, add the following line to the conf/server.xml file:
conf/server.xml - entry
=========================
<Listener className="org.mule.module.tomcat.MuleTomcatListener" />
Create a mule-libs subdirectory under the Tomcat home directory
Copy the contents of the Mule lib folder with all its subdirectories – except /boot to the mule-libs/ subdirectory 
of your Tomcat home directory. Do not flatten the directory structure.
Copy the mule-module-tomcat-<version>.jar file to the mule-libs/mule/ directory in your Tomcat home directory.
Copy the following libraries from your Mule lib/boot/ directory to your Tomcat `mule-libs/opt/`directory:

1)commons-cli-1.2.jar 

2)jcl-over-slf4j-1.7.7.jar

3)log4j-jcl-2.1.jar

4)slf4j-api-1.7.7.jar

5)disruptor-3.3.0.jar

6)wrapper-3.5.26.jar

7)log4j-slf4j-impl-2.1.jar

8)log4j-api-2.1.jar

9)log4j-core-2.1.jar

In the Tomcat conf/catalina.properties file, add the following to common.loader 
(preceded by a comma to separate it from existing values):

conf/catalina.properties:
=========================
${catalina.home}/mule-libs/user/*.jar,${catalina.home}/mule-libs/mule/*.jar,${catalina.home}/mule-libs/opt/*.jar
Deploying Mule Applications in Tomcat
=====================================
Package your Mule application’s configuration files and custom Java classes in a .war file
(see Application Server Based Hot Deployment).

In the Maven project all Mule provided dependencies -ie any library provided in the 
mule-libs directory- must have a <scope>provided</scope> definition to prevent classloading conflicts
between duplicated libraries.
Copy your application’s .war file, then paste it in the Tomcat /webapps directory.
Tomcat hot deploys the application.
If you need to make a change to the configuration or Java file in the Mule application, modify 
the file in the expanded directory under the Tomcat /webapps directory, then touch the web.xml
file (for example, simply add and delete a space in the file and then save it). 
These actions trigger Tomcat to redeploy the application.

Alternatively, you can modify the application’s source files, repackage them as a .war file, then drop the
new .war file into the /webapps directory to trigger Tomcat to redeploy the application.

TO RUN MUle with integrating with Mule Standalone Server
=========================================================
mule -app mule_basics
To deploy this application in Mule Standalone we need to create a deployable Zip file
and we can create it by right click on the Mule application, and then select Export option, 
and then select Anypoint studio project to Mule deployable Archive option from the menu in Any point studio.

Once done , we need to start our mule standalone server. We need to come into bin folder 
under Mule Standalone folder, and there we will find mule.bat ( for windows )
We can now click mule.bat  to start our standalone server
command:
========
mule -app {application name}

mule -app mule_basics 

mule_basics is created zip file name or application name

