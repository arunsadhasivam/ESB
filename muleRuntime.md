
To use Mule, either use Any point studio , or Mule standalone runtime(without Anypoint Studio) , or MMC (mule enterprise management console)
1)Anypoint studio-
2)Mule stand alone - https://developer.mulesoft.com/download-mule-esb-runtime 
file will be in name C:\mule-standalone-3.7.0\bin
3)https://www.mulesoft.com/dl/mmc
file download will be mmc-distribution-mule-console-bundle-3.7.0

Mule Stan Alone -Mule Runtime
=============================

When launched, Mule looks for a configuration file called
mule-config.xml, but you can include a file name (and path) to load
Mule with a different file of your own.
"%MULE_HOME%\bin\mule.bat" -config bin/mule-config.xml

Mule can be loaded by running it and using any one of its command-line
arguments. The main parameter to use is –config

Mule can be launched programmatically by using the org.mule.
MuleServer class. This class needs to be created; its constructor accepts a
comma-separated list of configuration files that you want to use, as shown
here:
MuleServer server = new MuleServer ("myConfig.xml,myOtherConfig.xml");
server.start (true);


Installing Mule as a Service (or Daemon)

Apart from being run in a stand-alone fashion, Mule can also be installed as
a service on Windows or as a daemon on Unix.
On Windows, use the install parameter shown here:
mule install –config myConfig.xml
This can be reversed by using the remove command:
mule remove
Once installed, Mule can be started, stopped, or restarted. In each case, the
config parameter will accept a comma-separated list of configuration files
to use:
mule start | restart | stop –config myConfig.xml
Additionally, you can use the following Windows net command to



mule Runtime:
============
https://docs.mulesoft.com/mule-user-guide/v/3.7/adding-community-runtime

= Adding Community Runtime
:keywords: installing, community runtime, ce, open source

*Anypoint Studio* comes bundled with an embedded Enterprise runtimes with a 30-day Enterprise trial license. You can add Community runtime to your Anypoint Studio instance to build and test applications in Mule's free, open-source runtime environment.

. In Studio, under the *Help* menu, select *Install New Software.*

. In the *Work With* field of the *Install* wizard, use the drop-down menu to select:
+
`Mule ESB Runtimes for Anypoint Studio`
+
image:StudioRuntimes.png[StudioRuntimes]

. Check the box to select *Anypoint Studio Community Runtimes*, and click *Next*.

. Click one or more runtimes you want to install. If you only want one version, expand the item and click the version you want. After selecting one or more versions, click *Next*.
+
image:36CmtyEd.png[36CmtyEd]

. Click to agree to the terms and conditions of the license agreement, and click *Finish*. Studio installs the Community runtimes. This may take several minutes to complete depending on the speed of your Internet connection and the number of runtimes you select.

. Click to agree to restart Anypoint Studio.

. When Studio restarts, under the File menu, select *New* > *Mule Project.*

. In the New Project wizard, click to select a CE option (CE stands for Community Edition).
+
image:36CEEEProject.png[36CEEEProject]

[WARNING]
====
*Are you behind a firewall?*

If you are on a network with firewall restrictions, you may find that the Studio update sites are blocked and you are unable to download extensions. Allow the following sites on your firewall to allow Studio to connect to the update sites:


== Change the Runtime of an Existing Project

. Complete the procedure above to install additional Mule runtimes on your instance of Studio. 

. In the *Package Explorer* in Studio, double-click the `mule-project.xml` file to open it.

. Use the drop-down menu next to *Server Runtime* to select a new Mule runtime.
+
[WARNING]
====
*The Community runtime does not support all the features available in Enterprise runtime.* If you switch runtimes from Enterprise to Community, be aware that some of your configurations may not be supported.
====
. If changing from Enterprise to Community, Studio displays a warning to advise that it may initiate updates to the namespace, and asks for your permission to proceed; click *Yes* to continue. 

. Studio saves the change. Close the `mule-project.xml` file.

== See Also

* Read a link:http://blogs.mulesoft.org/one-studio/[blog post] and/or release strategy explaining the Single Studio distribution.
* Want to upgrade to Mule's Enterprise runtime? link:/mule-user-guide/v/3.7/installing-an-enterprise-license[Install an Enterprise license].
* Get started with link:/mule-fundamentals/v/3.7[Mule Fundamentals].
* Access a list of all the link:/mule-user-guide/v/3.7/studio-update-sites[update sites] available for your version of Anypoint Studio.
* link:/mule-user-guide/v/3.7/installing[Which version of Mule am I using?]
