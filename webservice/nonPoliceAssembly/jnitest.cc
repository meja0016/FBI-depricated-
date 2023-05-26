#include<stdio.h>
#include<jni.h>
#include "JNITest.h"
JNIEXPORT void JNICALL Java_JNITest_greet
   (JNIEnv *env, jobject obj){
          int res;
    __asm__ ( "movl $30, %%eax;"
                "movl $10, %%ebx;"
                "subl %%ebx, %%eax ":"=a"(res));
    printf("%d",res);
      return;
}
