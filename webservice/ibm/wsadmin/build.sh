#!/bin/sh

javac -cp /tmp/com.ibm.ws.ejb.thinclient_9.0.jar nonPoliceServiceLocator.java
java -cp /tmp/com.ibm.ws.ejb.thinclient_9.0.jar:. nonPoliceServiceLocator
