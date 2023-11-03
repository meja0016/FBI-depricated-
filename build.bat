'https://download.oracle.com/java/20/latest/jdk-20_windows-x64_bin.zip

sdk\bin\javac -cp sdk\lib/servlet-api.jar:. nonPoliceServlet.java
#sdk\bin\javadoc -sourcepath src/ -classpath .\classes\   marx.maxplank.daimler.ibm
timeout 15 > %tmp%/NULL

