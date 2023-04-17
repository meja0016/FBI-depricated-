#include <jni.h>   
#include <stdio.h> 
#include "JNI.h"
 
JNIEXPORT void JNICALL Java_JNI_sayHello(JNIEnv *env, jobject thisObj) {
   printf("Hello World!\n");
   return;
}
