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

:# Set up environment
cd /d "%~dp0"
call .\setupSamp %*
if not .%ERROR% == . goto END

:# Test if the JAX-WS Sample is installed
if not exist "%CONFIG_ROOT%\cells\%WAS_CELL%\applications\JaxWSServicesSamples.ear" goto NOTINSTALLED

:# If no policy arg, delete all
if not "%WAS_POLICY%" == "" goto PARMOK
set WAS_POLICY=*
:PARMOK

:# Remove the Policy attachment
call "%WAS_HOME%\bin\wsadmin" %PROFOPT% -lang jython -f "%SAMPLES_HOME%\scripts\bindings.py" remove "%WAS_POLICY%" %WAS_NODE% %WAS_CELL% %WAS_SERVER% %*
goto END

:NOTINSTALLED
echo .
echo ERROR: The JAX-WS Sample Application EAR file is not installed
echo to %USER_INSTALL_ROOT% %WAS_CELL% %WAS_NODE%
goto END

:END
