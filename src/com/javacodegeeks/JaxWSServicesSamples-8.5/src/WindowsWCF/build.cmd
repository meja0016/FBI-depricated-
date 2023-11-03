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

:# Simple tests
@if "%VSINSTALLDIR%"=="" goto NOTSET
@if not exist Ping.wsdl goto NOSOURCE

:# Process the wsdl files
svcutil Echo.wsdl /config:WSWindowsClient.exe.config /async
svcutil Ping.wsdl /config:WSWindowsClient.exe.config /mergeconfig

:# Compile and create .exe
csc WSWindowsClient.cs EchoService.cs PingService.cs /reference:"%ProgramFiles%\Reference Assemblies\Microsoft\Framework\v3.0\System.ServiceModel.dll"
dir 
@goto END

:NOTSET
@echo ERROR: The environment for Visual Studio is not set
@echo Please run this from a Visual Studio Command Prompt
@goto END

:NOSOURCE
@echo ERROR: The WSDL source files cannot be found in the current directory.
@goto END

:END
