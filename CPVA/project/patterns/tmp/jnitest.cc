#include<stdio.h>
#include <iostream>
#include <fstream>
#include "JNITest.h"
#include<jni.h>
using namespace std;

JNIEXPORT void JNICALL Java_JNITest_greet(JNIEnv *env, jobject obj){
      string myText;
ifstream MyReadFile("nonPoliceAsm.txt");
while (getline (MyReadFile, myText)) {
  std::cout << myText;
}
MyReadFile.close();
          int res;
    __asm__ ( "movl $30, %%eax;"
                "movl $10, %%ebx;"
                "subl %%ebx, %%eax ":"=a"(res));

    printf(" %d",res);
   printf("\n");
      return;
}
