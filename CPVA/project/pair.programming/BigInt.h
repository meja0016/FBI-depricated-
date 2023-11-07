#ifndef BIGINT_CLASS_H
#define BIGINT_CLASS_H   
#include "BigInt.h"

class BigInt{
    int i;
  public:
    BigInt(){}
  void set(int j){
    i=j;
  }

    int calc(BigInt j,BigInt k){
        return j.i + k.i;
    }
};
#endif BIGINT_CLASS_H   

