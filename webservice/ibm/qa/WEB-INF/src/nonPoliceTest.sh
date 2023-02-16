#!/bin/sh
unset JAVA_TOOL_OPTIONS
export CLASSPATH=$CLASSPATH:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar
javac *.java
java  TestRunner
rm -rf *.class
#javadoc -d javadoc *.java
