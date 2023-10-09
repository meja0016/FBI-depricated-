$dir=[Environment]::GetFolderPath("Desktop")
$env:PATH="$env:PATH;$dir/app/jvm/bin"
javac -cp "..\..\lib\itext-2.1.7.jar;." .\nonPoliceBook.java
javac -cp ".;..\..\lib\itext-2.1.7.jar" .\nonPolice.java
java -cp "..\..\lib\itext-2.1.7.jar;." .\nonPoliceBook
