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

SET ERROR=
SET PROFOFT=

:# default server name if it is not passed as a command parameter
SET WAS_SERVER=server1

if .%1 == . goto NOPROFILE
if .%1 == .-user goto NOPROFILE
set WAS_PROFILE=%1
set PROFOPT=-profileName %WAS_PROFILE%
shift
:NOPROFILE

if not .%WAS_HOME% == . goto setSamp
SET ERROR=1
echo ERROR - Environment Variable WAS_HOME is not defined
goto END

:setSamp
set SAMPLES_HOME=%~dp0..\..
cd "%WAS_HOME%\bin"
set REPLACE_WAS_HOME=%WAS_HOME%
call "setupCmdLine.bat"
cd "%~dp0"
SET PATH=%JAVA_HOME%\bin;%PATH%

if .%1 == . goto NONODE
if .%1 == .-user goto NONODE
set WAS_CELL=%1
shift
if .%1 == . goto NONODE
if .%1 == .-user goto NONODE
set WAS_NODE=%1
shift
if .%1 == . goto NONODE
if .%1 == .-user goto NONODE
set WAS_SERVER=%1
shift
:NONODE

: Test Profile name
if exist "%USER_INSTALL_ROOT%" goto CONTINUE1
echo ERROR: Profile %WAS_PROFILE% does not exist
echo Valid profiles:
call "%WAS_HOME%\bin\manageprofiles" -listProfiles
goto ERROR
:CONTINUE1
: Test Cell name
if exist "%CONFIG_ROOT%\cells\%WAS_CELL%" goto CONTINUE2
echo ERROR: Cell %WAS_CELL% does not exist
echo Valid cells on server %WAS_PROFILE%:
dir /b "%CONFIG_ROOT%\cells"
goto ERROR
:CONTINUE2
: Test Node name
if exist "%CONFIG_ROOT%\cells\%WAS_CELL%\nodes\%WAS_NODE%" goto CONTINUE3
echo ERROR: Node %WAS_NODE% does not exist
echo Valid nodes on cell %WAS_CELL%:
dir /b "%CONFIG_ROOT%\cells\%WAS_CELL%\nodes"
goto ERROR
:CONTINUE3
goto END

:ERROR
SET ERROR=1
echo .
echo Usage:
echo   %PROGNAME% [profile] [cell] [node] [server] [-user user -password password]
echo optional parameters:
echo   profile is your WebSphere Application Server profile
echo   cell is the cell name for the profile
echo   node is the node name for the server node
echo   server is the server name
echo Example:
echo   %PROGNAME% AppSrv01 LINK-T42Node01Cell LINK-T42Node01 server1
goto END

:END
