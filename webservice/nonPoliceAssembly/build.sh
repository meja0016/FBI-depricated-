#!/bin/sh

#cc -fPIC -shared -I/home/codespace/java/current/include -I/home/codespace/java/current/include/linux  -I./. -o emc_calc.so jnitest.cc
#nm emc_calc.so
#nm emc_calc.so | grep subtract
#javac nonPoliceJni.java
#java -Djava.library.path=emc_calc.so nonPoliceJni

java -Djava.library.path=/home/user1/JNI_project JNITest












#//https://www.developer.com/open-source/getting-started-with-jni/