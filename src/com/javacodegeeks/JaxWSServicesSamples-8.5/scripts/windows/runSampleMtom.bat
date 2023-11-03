:# COPYRIGHT LICENSE: 
:# This information contains sample code provided in source code form. You may 
:# copy, modify, and distribute these sample programs in any form without 
:# payment to IBM for the purposes of developing, using, marketing or 
:# distributing application programs conforming to the application programming
:# interface for the operating platform for which the sample code is written. 
:# Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE
:# ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, 
:# INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF 
:# MERCHANTABILITY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, 
:# TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE 
:# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES
:# ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO 
:# OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR 
:# MODIFICATIONS TO THE SAMPLE SOURCE CODE.
@echo off
setlocal

if not .%WAS_HOME% == . goto setSamp
echo ERROR - Environment Variable WAS_HOME  is not defined
goto END

:setSamp
cd "%WAS_HOME%\bin"
set REPLACE_WAS_HOME=%WAS_HOME%
call "setupCmdLine.bat"

set ENDORSED=-Djava.endorsed.dirs="%WAS_HOME%\runtimes\endorsed"

set THIN_JAR_FILE=com.ibm.jaxws.thinclient_8.0.0.jar
set THIN_JAR=%WAS_HOME%\runtimes\%THIN_JAR_FILE%
if exist "%THIN_JAR%" goto INSTALLOK
echo Jar file %THIN_JAR_FILE% cannot be located.

set THIN_JAR_FILE=com.ibm.jaxws.thinclient_8.5.0.jar
set THIN_JAR=%WAS_HOME%\runtimes\%THIN_JAR_FILE%
if exist "%THIN_JAR%" goto INSTALLOK
echo Jar file %THIN_JAR_FILE% cannot be located.

echo This sample requires installation of "Stand-alone thin clients".
echo Please correct the installation options before running this sample.
goto END

:INSTALLOK
set CLASSPATH=%THIN_JAR%;%~dp0..\..\installableApps\WSSampleMTOMClient.jar
"%JAVA_HOME%\bin\java" %ENDORSED% -cp "%CLASSPATH%" org.apache.axis2.jaxws.sample.mtom.SampleMTOMTests %*
:END

