mkdir C:\Users\Custom-tc-cen11\Desktop\nonPolice
mkdir C:\Users\Custom-tc-cen11\Desktop\nonPolice/WEB-INF
mkdir C:\Users\Custom-tc-cen11\Desktop\nonPolice/WEB-INF/src
Compress-Archive -Path C:\Users\Custom-tc-cen11\Desktop\nonPolice -DestinationPath C:\Users\Custom-tc-cen11\Desktop\nonPolice.zip
Rename-Item C:\Users\Custom-tc-cen11\Desktop\nonPolice.zip C:\Users\Custom-tc-cen11\Desktop\nonPolice.war
Remove-Item C:\Users\Custom-tc-cen11\Desktop\nonPolice
