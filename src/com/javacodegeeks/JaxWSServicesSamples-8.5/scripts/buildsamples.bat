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
@setlocal

:# CONSOLE_ENCODING controls the output encoding used for stdout/stderr
:#    console - encoding is correct for a console window
:#    file    - encoding is the default file encoding for the system
:#    <other> - the specified encoding is used.  e.g. Cp1252, Cp850, SJIS
:# SET CONSOLE_ENCODING=-Dws.output.encoding=console

if not .%WAS_HOME% == . goto setSamp
echo ERROR - Environment Variable WAS_HOME  is not defined
goto END

:setSamp
set SAMPLES_HOME=%~dp0..
cd "%WAS_HOME%\bin"
set REPLACE_WAS_HOME=%WAS_HOME%
call "setupCmdLine.bat"
cd "%SAMPLES_HOME%"
set ANT_ARGS=-Dbasedir="%SAMPLES_HOME%" -Dwas_home="%WAS_HOME%" -Dprereq.classpath="%WAS_HOME%\runtimes\com.ibm.jaxws.thinclient_8.0.0.jar;%WAS_HOME%\runtimes\com.ibm.jaxws.thinclient_8.5.0.jar;%WAS_HOME%\lib\j2ee.jar" 

set CMD_NAME=%~nx0
set CMD_NAME_ONLY=%~n0

:setArgs
if "%1"=="" goto doneArgs
set ANT_ARGS=%ANT_ARGS% %1
shift
goto setArgs

:doneArgs
set WAS_ANT_EXTRA_CLASSPATH=%WAS_HOME%\lib\bootstrap.jar;%WAS_HOME%\optionalLibraries\jython.jar;%WAS_HOME%\optionalLibraries\jython\jython.jar
set WAS_ANT_CLASSPATH=%WAS_ANT_CLASSPATH%;%WAS_HOME%\plugins;%WAS_HOME%\optionalLibraries\jython.jar;%WAS_HOME%\lib\j2ee.jar

:# Generate a temporary path name for the properties file.  Be sure the dir exists and is writable.
:# Try using the profile's temp space first before using the system's temp space.
if not defined USER_INSTALL_ROOT goto GEN_SYS_TMP_DIR
:GEN_TMP_DIR
set TMPWASDIR="%USER_INSTALL_ROOT:"=%\temp\%CMD_NAME_ONLY%.%RANDOM%"
if exist %TMPWASDIR% goto GEN_TMP_DIR
mkdir %TMPWASDIR%
if exist %TMPWASDIR% goto WRITE_PROPERTIES_FILE

:GEN_SYS_TMP_DIR
set TMPWASDIR="%TEMP:"=%\%CMD_NAME_ONLY%.%RANDOM%"
if exist %TMPWASDIR% goto GEN_SYS_TMP_DIR
mkdir %TMPWASDIR%
if not exist %TMPWASDIR% ( echo The TEMP environment variable must be set to a writable directory. ) & goto :EOF

:WRITE_PROPERTIES_FILE
set TMPJAVAPROPFILE="%TMPWASDIR:"=%\%CMD_NAME_ONLY%.properties"
:# write one property per line into the temp file. - Format is propname=value   
:# Remember to handle the "\" char in paths, as it must become two "\\" in order for java to handle properly.
>  %TMPJAVAPROPFILE% echo # Temporary Java Properties File for the %CMD_NAME% WAS command.
set TMPPROP=%WAS_HOME:\=\\%\\plugins;%WAS_EXT_DIRS:\=\\%;%WAS_ANT_CLASSPATH:\=\\%;
>> %TMPJAVAPROPFILE% echo ws.ext.dirs=%TMPPROP:"=%
set TMPPROP=%WAS_ANT_EXTRA_CLASSPATH:\=\\%
>> %TMPJAVAPROPFILE% echo was.ant.extra.classpath=%TMPPROP:"=%

set CLASSPATH=%WAS_CLASSPATH%

"%JAVA_HOME%\bin\java" -Dcmd.properties.file=%TMPJAVAPROPFILE% %WAS_LOGGING% %CONSOLE_ENCODING% "%CLIENTSAS%" "%CLIENTSSL%" "-DWAS_USER_SCRIPT=%WAS_USER_SCRIPT%" %USER_INSTALL_PROP% -Dwas.install.root="%WAS_HOME%" "-Dwas.root=%WAS_HOME%" com.ibm.ws.bootstrap.WSLauncher org.apache.tools.ant.Main %ANT_ARGS%

set RC=%ERRORLEVEL%

:# Cleanup the temporary java properties file and dir.
del %TMPJAVAPROPFILE%
rmdir %TMPWASDIR%

:# Need to pass the RC through the endlocal
:END
@endlocal & exit /b %RC%