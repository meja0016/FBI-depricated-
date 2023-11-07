#include "BigInt.h"
#include <string.h>
#include <iostream>
using namespace std;

int main(){
    BigInt* BigInt;

    string food = "Pizza";
    string* ptr = &food;
    cout << food <<"\n";
    cout << &food << "\n";
    cout << ptr << "\n";

    cout << BigInt->calc() << "\n";
    return 0;

}